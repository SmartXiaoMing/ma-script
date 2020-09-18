package com.xiaoming.script.compile;

import com.xiaoming.script.gen.MaScriptLexer;
import com.xiaoming.script.gen.MaScriptParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.*;
import java.lang.String;

import static com.xiaoming.script.compile.MaExpr.*;

/**
 * @author: xiaoming
 * @since: 2018-2-13
 */
public class MaScript {
    static class ErrorListener implements ANTLRErrorListener {
        StringBuilder messageBuilder = new StringBuilder();
        int errorCount = 0;
        int warningCount = 0;

        public boolean isSuccess() {
            return errorCount == 0 && warningCount == 0;
        }

        public String getErrorMsg() {
            return messageBuilder.toString();
        }

        public void reset() {
            messageBuilder = new StringBuilder();
            errorCount = 0;
            warningCount = 0;
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                                int charPositionInLine, String msg, RecognitionException e) {
            String message = "[ERROR] line " + line + ":" + charPositionInLine + " " + msg;
            messageBuilder.append(message).append("\n");
            errorCount++;
        }

        @Override
        public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
                                    boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
            // errorMsg = "[语义不明确] 位置: (" + startIndex + ", " + stopIndex + ")";
        }

        @Override
        public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex,
                                                int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
            // errorMsg = "[attempting] startIndex: " + startIndex + ", endIndex: " + stopIndex;
        }

        @Override
        public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex,
                                             int stopIndex, int prediction, ATNConfigSet configs) {
            // errorMsg = "[sensitivity] startIndex: " + startIndex + ", endIndex: "
            //        + stopIndex + ", prediction: " + prediction;
        }
    }

    public static String escapeString(String text) {
        StringBuffer buffer = new StringBuffer(text.length());
        int i = 1;
        while (i < text.length() - 1) { // skip first " and end "
            if (text.charAt(i) != '\\') {
                buffer.append(text.charAt(i));
            } else {
                switch (text.charAt(i+1)) {
                    case '\\': buffer.append('\\'); ++i;break;
                    case 't': buffer.append('\t'); ++i;break;
                    case 'r': buffer.append('\r'); ++i;break;
                    case 'n': buffer.append('\n'); ++i;break;
                    case 'b': buffer.append('\b'); ++i;break;
                    case '"': buffer.append('"'); ++i;break;
                    case '\'': buffer.append('\''); ++i;break;
                    default: buffer.append('\\');
                }
            }
            ++i;
        }
        return buffer.toString();
    }

    public static String escapeFormatString(String text) {
        StringBuffer buffer = new StringBuffer(text.length());
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) != '\\') {
                buffer.append(text.charAt(i));
            } else {
                switch (text.charAt(i+1)) {
                    case '\\': buffer.append('\\'); ++i;break;
                    case 't': buffer.append('\t'); ++i;break;
                    case 'r': buffer.append('\r'); ++i;break;
                    case 'n': buffer.append('\n'); ++i;break;
                    case 'b': buffer.append('\b'); ++i;break;
                    case '"': buffer.append('"'); ++i;break;
                    case '$': buffer.append('$'); ++i;break;
                    case '{': buffer.append('{'); ++i;break;
                    case '}': buffer.append('}'); ++i;break;
                    case '\'': buffer.append('\''); ++i;break;
                    case '`': buffer.append('`'); ++i;break;
                    default: buffer.append('\\');
                }
            }
            ++i;
        }
        return buffer.toString();
    }

    public Evaluable translate(MaContext maContext, ParserRuleContext context) {
        // System.out.println("enter translate: " + context.getText() + ", class: " + context.getClass().getName());
        if (context instanceof MaScriptParser.NullExprContext) {
            return Evaluable.Null;
        }

        if (context instanceof MaScriptParser.BoolExprContext) {
            if (context.getText().equals("true")) {
                return Evaluable.True;
            }
            return Evaluable.False;
        }

        if (context instanceof MaScriptParser.IntExprContext) {
            return Evaluable.get(Long.valueOf(context.getText()));
        }

        if (context instanceof MaScriptParser.FloatExprContext) {
            return Evaluable.get(Double.valueOf(context.getText()));
        }

        if (context instanceof MaScriptParser.StringExprContext) {
            String text = context.getText();
            return Evaluable.get(escapeString(text));
        }

        if (context instanceof MaScriptParser.StringExprContext) {
            String text = context.getText();
            StringBuffer buffer = new StringBuffer(text.length());
            int i = 1;
            while (i < text.length() - 1) { // skip first " and end "
                if (text.charAt(i) != '\\') {
                    buffer.append(text.charAt(i));
                } else {
                    switch (text.charAt(i+1)) {
                        case '\\': buffer.append('\\'); ++i;break;
                        case 't': buffer.append('\t'); ++i;break;
                        case 'r': buffer.append('\r'); ++i;break;
                        case 'n': buffer.append('\n'); ++i;break;
                        case 'b': buffer.append('\b'); ++i;break;
                        case '"': buffer.append('"'); ++i;break;
                        case '\'': buffer.append('\''); ++i;break;
                        default: buffer.append('\\');
                    }
                }
                ++i;
            }
            return Evaluable.get(buffer.toString());
        }

        if (context instanceof MaScriptParser.IdExprContext) {
            MaScriptParser.IdExprContext c = (MaScriptParser.IdExprContext) context;
            String name = c.Id().getText();
            if (maContext != null) {
                if (!maContext.isDefined(name)) {
                    Token token = c.Id().getSymbol();
                    errorListener.messageBuilder.append("[WARNING] line ")
                        .append(token.getLine()).append(":").append(token.getCharPositionInLine())
                        .append(" symbol '").append(name).append("' is undefined\n");
                    errorListener.warningCount++;
                }
            }
            return new IdExpr(name);
        }

        if (context instanceof MaScriptParser.FuncDefExprContext) {
            MaScriptParser.FuncDefExprContext c = (MaScriptParser.FuncDefExprContext) context;
            FunctionType f = new FunctionType();
            FuncDefExpr expr = new FuncDefExpr();
            expr.function = f;
            if (c.Id() != null) {
                expr.name = c.Id().getText();
                f.name = expr.name;
                if (maContext != null) {
                    maContext.define(f.name, f);
                }
            }
            MaContext sub = maContext == null ? null : maContext.getSub();
            if (c.ids() != null) {
                c.ids().Id().forEach(x -> {
                    String name = x.getText();
                    if (sub != null) {
                        sub.define(name, null);
                    }
                    f.nameList.add(name);
                });
            }
            if (c.stats() != null) {
                f.body = translate(sub, c.stats());
            }
            return expr;
        }

        if (context instanceof MaScriptParser.LambdaDefExprContext) {
            MaScriptParser.LambdaDefExprContext c = (MaScriptParser.LambdaDefExprContext) context;
            FunctionType f = new FunctionType();
            FuncDefExpr expr = new FuncDefExpr();
            expr.function = f;
            MaContext sub = maContext == null ? null : maContext.getSub();
            c.lambdaParam().Id().forEach(x -> {
                String name = x.getText();
                if (sub != null) {
                    sub.define(name, null);
                }
                f.nameList.add(name);
            });
            if (c.lambdaBody().exprs() != null) {
                f.body = translate(sub, c.lambdaBody().exprs());
            } else {
                f.body = translate(sub, c.lambdaBody().stats());
            }
            return expr;
        }

        if (context instanceof MaScriptParser.MemberIndexExprContext) {
            MemberIndexExpr expr = new MemberIndexExpr();
            MaScriptParser.MemberIndexExprContext c1 = (MaScriptParser.MemberIndexExprContext) context;
            expr.v1 = translate(maContext, c1.singleExpr());
            expr.v2 = translate(maContext, c1.exprs());
            if (options != null) {
                expr.nullIndex = options.nullIndex;
            }
            return expr;
        }

        if (context instanceof MaScriptParser.MemberDotExprContext) {
            MemberDotExpr expr = new MemberDotExpr();
            MaScriptParser.MemberDotExprContext c1 = (MaScriptParser.MemberDotExprContext) context;
            expr.v1 = translate(maContext, c1.singleExpr());
            expr.v2 = c1.Id().getText();
            expr.nullDot = MaCompileOptions.getNullDot(options);
            expr.lineNumber = c1.Id().getSymbol().getLine();
            return expr;
        }

        if (context instanceof MaScriptParser.FuncCallExprContext) {
            FuncCallExpr expr = new FuncCallExpr();
            MaScriptParser.FuncCallExprContext c = (MaScriptParser.FuncCallExprContext) context;
            expr.v1 = translate(maContext, c.singleExpr());
            if (c.exprs() != null) {
                c.exprs().singleExpr().forEach(x -> expr.v2.add(translate(maContext, x)));
            }
            return expr;
        }

        if (context instanceof MaScriptParser.MemberFuncCallExprContext) {
            MemberFuncCallExpr expr = new MemberFuncCallExpr();
            expr.nullDot = MaCompileOptions.getNullDot(options);
            MaScriptParser.MemberFuncCallExprContext c = (MaScriptParser.MemberFuncCallExprContext) context;
            expr.v1 = translate(maContext, c.singleExpr());
            expr.name = c.Id().getText();
            if (c.exprs() != null) {
                c.exprs().singleExpr().forEach(x -> expr.v2.add(translate(maContext, x)));
            }
            expr.lineNumber = c.Id().getSymbol().getLine();
            return expr;
        }

        if (context instanceof MaScriptParser.MemberIndexIncExprContext) {
            MaScriptParser.MemberIndexIncExprContext c = (MaScriptParser.MemberIndexIncExprContext) context;
            MemberIndexAssignExpr expr = new MemberIndexAssignExpr(
                    translate(maContext, c.singleExpr()),
                    translate(maContext, c.exprs()),
                    c.Inc().getText(),
                    Evaluable.get(1)
            );
            return expr;
        }

        if (context instanceof MaScriptParser.MemberDotIncExprContext) {
            MaScriptParser.MemberDotIncExprContext c = (MaScriptParser.MemberDotIncExprContext) context;
            MemberDotAssignExpr expr = new MemberDotAssignExpr(
                    translate(maContext, c.singleExpr()),
                    c.Id().getText(),
                    c.Inc().getText(),
                    Evaluable.get(1)
            );
            expr.lineNumber = c.Id().getSymbol().getLine();
            return expr;
        }

        if (context instanceof MaScriptParser.IdIncExprContext) {
            MaScriptParser.IdIncExprContext c = (MaScriptParser.IdIncExprContext) context;
            IdAssignExpr expr = new IdAssignExpr(c.Id().getText(), c.Inc().getText(), Evaluable.get(1));
            return expr;
        }

        if (context instanceof MaScriptParser.IncMemberIndexExprContext) {
            MaScriptParser.MemberIndexIncExprContext c = (MaScriptParser.MemberIndexIncExprContext) context;
            MemberIndexAssignExpr expr = new MemberIndexAssignExpr(
                    translate(maContext, c.singleExpr()),
                    translate(maContext, c.exprs()),
                    c.Inc().getText(),
                    Evaluable.get(1)
            );
            return expr;
        }

        if (context instanceof MaScriptParser.IncMemberDotExprContext) {
            MaScriptParser.IncMemberDotExprContext c = (MaScriptParser.IncMemberDotExprContext) context;
            MemberDotAssignExpr expr = new MemberDotAssignExpr(
                    translate(maContext, c.singleExpr()),
                    c.Id().getText(),
                    c.Inc().getText(),
                    Evaluable.get(1)
            );
            expr.lineNumber = c.Id().getSymbol().getLine();
            return expr;
        }

        if (context instanceof MaScriptParser.IncIdExprContext) {
            MaScriptParser.IncIdExprContext c = (MaScriptParser.IncIdExprContext) context;
            IdAssignExpr expr = new IdAssignExpr(c.Id().getText(), c.Inc().getText(), Evaluable.get(1));
            return expr;
        }

        if (context instanceof MaScriptParser.NotExprContext) {
            MaScriptParser.NotExprContext c = (MaScriptParser.NotExprContext) context;
            NotExpr expr = new NotExpr();
            expr.not = c.Not().getText().length() % 2 == 1;
            expr.v1 = translate(maContext, c.singleExpr());
            return expr;
        }

        if (context instanceof MaScriptParser.NotExprContext) {
            MaScriptParser.NotExprContext c = (MaScriptParser.NotExprContext) context;
            NotExpr expr = new NotExpr();
            expr.not = c.Not().getText().length() % 2 == 1;
            expr.v1 = translate(maContext, c.singleExpr());
            return expr;
        }

        if (context instanceof MaScriptParser.UnaryMinusExprContext) {
            MaScriptParser.UnaryMinusExprContext c = (MaScriptParser.UnaryMinusExprContext) context;
            if (c.Add().getText().equals("-")) {
                UnaryMinusExpr expr = new UnaryMinusExpr();
                expr.v1 = translate(maContext, c.singleExpr());
                return expr;
            } else {
                translate(maContext, c.singleExpr());
            }
        }

        if (context instanceof MaScriptParser.MultExprContext) {
            MaScriptParser.MultExprContext c = (MaScriptParser.MultExprContext) context;
            return new BiExpr(c.Mult().getText(), translate(maContext, c.singleExpr(0)), translate(maContext, c.singleExpr(1)));
        }

        if (context instanceof MaScriptParser.AddExprContext) {
            MaScriptParser.AddExprContext c = (MaScriptParser.AddExprContext) context;
            return new BiExpr(c.Add().getText(), translate(maContext, c.singleExpr(0)), translate(maContext, c.singleExpr(1)));
        }

        if (context instanceof MaScriptParser.RelationExprContext) {
            MaScriptParser.RelationExprContext c = (MaScriptParser.RelationExprContext) context;
            return new BiExpr(c.Relation().getText(), translate(maContext, c.singleExpr(0)), translate(maContext, c.singleExpr(1)));
        }

        if (context instanceof MaScriptParser.EqExprContext) {
            MaScriptParser.EqExprContext c = (MaScriptParser.EqExprContext) context;
            return new BiExpr(c.Eq().getText(), translate(maContext, c.singleExpr(0)), translate(maContext, c.singleExpr(1)));
        }

        if (context instanceof MaScriptParser.AndExprContext) {
            AndExpr expr = new AndExpr();
            MaScriptParser.AndExprContext c = (MaScriptParser.AndExprContext) context;
            expr.v1 = translate(maContext, c.singleExpr(0));
            expr.v2 = translate(maContext, c.singleExpr(1));
            return expr;
        }

        if (context instanceof MaScriptParser.OrExprContext) {
            OrExpr expr = new OrExpr();
            MaScriptParser.OrExprContext c = (MaScriptParser.OrExprContext) context;
            expr.v1 = translate(maContext, c.singleExpr(0));
            expr.v2 = translate(maContext, c.singleExpr(1));
            return expr;
        }

        if (context instanceof MaScriptParser.TernaryExprContext) {
            TernaryExpr expr = new TernaryExpr();
            MaScriptParser.TernaryExprContext c = (MaScriptParser.TernaryExprContext) context;
            expr.v1 = translate(maContext, c.singleExpr(0));
            expr.v2 = translate(maContext, c.singleExpr(1));
            expr.v3 = translate(maContext, c.singleExpr(2));
            return expr;
        }

        if (context instanceof MaScriptParser.IdAssignExprContext) {
            MaScriptParser.IdAssignExprContext c = (MaScriptParser.IdAssignExprContext) context;
            if (options != null && options.assignAsEq) {
                return new BiExpr("==", new IdExpr(c.Id().getText()), translate(maContext, c.singleExpr()));
            } else {
                return new IdAssignExpr(c.Id().getText(), "=", translate(maContext, c.singleExpr()));
            }
        }

        if (context instanceof MaScriptParser.ExprAssignExprContext) { // NOTE treat = as ==
            MaScriptParser.ExprAssignExprContext c = (MaScriptParser.ExprAssignExprContext) context;
            return new BiExpr("==", translate(maContext, c.singleExpr(0)), translate(maContext, c.singleExpr(1)));
        }

        if (context instanceof MaScriptParser.MemberIndexAssignExprContext) {
            MaScriptParser.MemberIndexAssignExprContext c = (MaScriptParser.MemberIndexAssignExprContext) context;
            if (options != null && options.assignAsEq) {
                MemberIndexExpr expr = new MemberIndexExpr();
                expr.v1 = translate(maContext, c.singleExpr(0));
                expr.v2 = translate(maContext, c.exprs());
                return new BiExpr("==", expr, translate(maContext, c.singleExpr(1)));
            } else {
                MemberIndexAssignExpr expr = new MemberIndexAssignExpr(
                        translate(maContext, c.singleExpr(0)),
                        translate(maContext, c.exprs()),
                        "=",
                        translate(maContext, c.singleExpr(1))
                );
                return expr;
            }
        }

        if (context instanceof MaScriptParser.MemberDotAssignExprContext) {
            MaScriptParser.MemberDotAssignExprContext c = (MaScriptParser.MemberDotAssignExprContext) context;
            if (options != null && options.assignAsEq) {
                MemberDotExpr memberDotExpr = new MemberDotExpr();
                memberDotExpr.v1 = translate(maContext, c.singleExpr(0));
                memberDotExpr.v2 = c.Id().getText();
                return new BiExpr("==", memberDotExpr, translate(maContext, c.singleExpr(1)));
            } else {
                MemberDotAssignExpr expr = new MemberDotAssignExpr(
                    translate(maContext, c.singleExpr(0)),
                    c.Id().getText(),
                    "=",
                    translate(maContext, c.singleExpr(1)));
                expr.lineNumber = c.Id().getSymbol().getLine();
                return expr;
            }
        }

        if (context instanceof MaScriptParser.IdAssignAppendExprContext) {
            MaScriptParser.IdAssignAppendExprContext c = (MaScriptParser.IdAssignAppendExprContext) context;
            IdAssignExpr expr = new IdAssignExpr(
                c.Id().getText(),
                c.AssignAppend().getText(),
                translate(maContext, c.singleExpr()));
            return expr;
        }

        if (context instanceof MaScriptParser.MemberIndexAssignAppendExprContext) {
            MaScriptParser.MemberIndexAssignAppendExprContext c = (MaScriptParser.MemberIndexAssignAppendExprContext) context;
            MemberIndexAssignExpr expr = new MemberIndexAssignExpr(
                    translate(maContext, c.singleExpr(0)),
                    translate(maContext, c.exprs()),
                    c.AssignAppend().getText(),
                    translate(maContext, c.singleExpr(1))
            );
            return expr;
        }

        if (context instanceof MaScriptParser.MemberDotAssignAppendExprContext) {
            MaScriptParser.MemberDotAssignAppendExprContext c = (MaScriptParser.MemberDotAssignAppendExprContext) context;
            MemberDotAssignExpr expr = new MemberDotAssignExpr(
                    translate(maContext, c.singleExpr(0)),
                    c.Id().getText(),
                    c.AssignAppend().getText(),
                    translate(maContext, c.singleExpr(1))
            );
            expr.lineNumber = c.Id().getSymbol().getLine();
            return expr;
        }

        if (context instanceof MaScriptParser.ExprsContext) {
            Exprs expr = new Exprs();
            MaScriptParser.ExprsContext c = (MaScriptParser.ExprsContext) context;
            c.singleExpr().forEach(x -> expr.list.add(translate(maContext, x)));
            return expr;
        }

        // [1,2,3]
        if (context instanceof MaScriptParser.ArrayExprContext) {
            MaScriptParser.ArrayExprContext c = (MaScriptParser.ArrayExprContext) context;
            ArrayExpr expr = new ArrayExpr();
            if (c.array().exprs() != null) {
                List<MaScriptParser.SingleExprContext> valueList = c.array().exprs().singleExpr();
                valueList.forEach(x -> expr.list.add(translate(maContext, x)));
            }
            return expr;
        }

        // {name:"123", value:"xxx"}
        if (context instanceof MaScriptParser.ObjectExprContext) {
            MaScriptParser.ObjectExprContext c = (MaScriptParser.ObjectExprContext) context;
            ObjectExpr expr = new ObjectExpr();
            int size = c.object().Id().size();
            for (int i = 0; i < size; ++i) {
                String name = c.object().Id(i).getText();
                Evaluable evaluable = translate(maContext, c.object().singleExpr(i));
                expr.map.put(name, evaluable);
            }
            return expr;
        }

        // {...}
        if (context instanceof MaScriptParser.BlockStatContext) {
            MaScriptParser.BlockStatContext c = (MaScriptParser.BlockStatContext) context;
            BlockStat stat = new BlockStat();
            if (c.stats() != null) {
                MaContext sub = maContext == null ? null : maContext.getSub();
                c.stats().stat().forEach(x -> stat.list.add(translate(sub, x)));
            }
            return stat;
        }

        // var a = 1, c = d;
        if (context instanceof MaScriptParser.VarStatContext) {
            MaScriptParser.VarStatContext c = (MaScriptParser.VarStatContext) context;
            VarStat stat = new VarStat();
            int size = c.Id().size();
            for (int i = 0; i < size; ++i) {
                String name = c.Id(i).getText();
                Evaluable evaluable = translate(maContext, c.singleExpr(i));
                stat.list.add(new AbstractMap.SimpleEntry<>(name, evaluable));
                if (maContext != null) {
                    maContext.define(name, null);
                }
            }
            return stat;
        }

        if (context instanceof MaScriptParser.EmptyStatContext) {
            MaScriptParser.EmptyStatContext c = (MaScriptParser.EmptyStatContext) context;
            EmptyStat stat = new EmptyStat();
            return stat;
        }

        if (context instanceof MaScriptParser.ExprsStatContext) {
            MaScriptParser.ExprsStatContext c = (MaScriptParser.ExprsStatContext) context;
            ExprsStat stat = new ExprsStat();
            c.exprs().singleExpr().forEach(x -> stat.list.add(translate(maContext, x)));
            return stat;
        }

        if (context instanceof MaScriptParser.IfStatContext) {
            MaScriptParser.IfStatContext c = (MaScriptParser.IfStatContext) context;
            IfStat stat = new IfStat();
            MaContext sub = maContext == null ? null : maContext.getSub();
            stat.v1 = translate(sub, c.exprs());
            stat.v2 = translate(sub, c.stat(0));
            if (c.stat().size() >= 2) {
                stat.v3 = translate(sub, c.stat(1));
            } else {
                stat.v3 = Evaluable.Null;
            }
            return stat;
        }

        if (context instanceof MaScriptParser.ForItStatContext) {
            MaScriptParser.ForItStatContext c = (MaScriptParser.ForItStatContext) context;
            ForItStat stat = new ForItStat();
            stat.name = c.Id().getText();
            MaContext sub = maContext == null ? null : maContext.getSub();
            if (sub != null) {
                sub.define(stat.name, null);
            }
            stat.v1 = translate(sub, c.singleExpr(0));
            stat.v2 = translate(sub, c.singleExpr(1));
            stat.v3 = translate(sub, c.singleExpr(2));
            stat.v4 = translate(sub, c.stat());
            return stat;
        }

        if (context instanceof MaScriptParser.ForInStatContext) {
            MaScriptParser.ForInStatContext c = (MaScriptParser.ForInStatContext) context;
            ForInStat stat = new ForInStat();
            MaContext sub = maContext == null ? null : maContext.getSub();
            stat.v1 = c.Id().getText();
            if (sub != null) {
                sub.define(stat.v1, null);
            }
            stat.v2 = translate(sub, c.singleExpr());
            stat.v3 = translate(sub, c.stat());
            return stat;
        }

        if (context instanceof MaScriptParser.ReturnStatContext) {
            MaScriptParser.ReturnStatContext c = (MaScriptParser.ReturnStatContext) context;
            ReturnStat stat = new ReturnStat();
            if (c.exprs() != null) {
                stat.v1 = translate(maContext, c.exprs());
            } else {
                stat.v1 = Evaluable.Null;
            }
            return stat;
        }

        if (context instanceof MaScriptParser.BreakStatContext) {
            MaScriptParser.BreakStatContext c = (MaScriptParser.BreakStatContext) context;
            BreakStat stat = new BreakStat();
            if (c.exprs() != null) {
                stat.v1 = translate(maContext, c.exprs());
            } else {
                stat.v1 = Evaluable.Null;
            }
            return stat;
        }

        if (context instanceof MaScriptParser.ContinuekStatContext) {
            return ContinueStat.inst;
        }

        if (context instanceof MaScriptParser.FuncDefStatContext) {
            MaScriptParser.FuncDefStatContext c = (MaScriptParser.FuncDefStatContext) context;
            FunctionType f = new FunctionType();
            FuncDefExpr expr = new FuncDefExpr();
            expr.function = f;
            if (c.Id() != null) {
                expr.name = c.Id().getText();
                f.name = expr.name;
                if (maContext != null) {
                    maContext.define(f.name, f);
                }
            }
            MaContext sub = maContext == null ? null : maContext.getSub();
            if (c.ids() != null) {
                c.ids().Id().forEach(x -> {
                    String name = x.getText();
                    if (sub != null) {
                        sub.define(name, null);
                    }
                    f.nameList.add(name);
                });
            }
            if (c.stats() != null) {
                f.body = translate(sub, c.stats());
            }
            return expr;
        }

        if (context instanceof MaScriptParser.PriorityExprContext) {
            MaScriptParser.PriorityExprContext c = (MaScriptParser.PriorityExprContext) context;
            return translate(maContext, c.exprs());
        }

        if (context instanceof MaScriptParser.StringFormatExprContext) {
            MaScriptParser.StringFormatExprContext c = (MaScriptParser.StringFormatExprContext) context;
            StringFormatExpr stringFormatExpr = new StringFormatExpr();
            c.stringFormatPart().forEach(x -> {
                if (x.TextFormat() != null) {
                    stringFormatExpr.evaluableList.add(Evaluable.get(escapeFormatString(x.TextFormat().getText())));
                } else if (x.IdInterp() != null) {
                    stringFormatExpr.evaluableList.add(new IdExpr(x.IdInterp().getText().substring(1))); // skip $
                } else {
                    stringFormatExpr.evaluableList.add(translate(maContext, x.singleExpr()));
                }
            });
            return stringFormatExpr;
        }

        if (context instanceof MaScriptParser.TriStringFormatExprContext) {
            MaScriptParser.TriStringFormatExprContext c = (MaScriptParser.TriStringFormatExprContext) context;
            StringFormatExpr stringFormatExpr = new StringFormatExpr();
            c.backStringFormatPart().forEach(x -> {
                if (x.BackTextFormat() != null) {
                    stringFormatExpr.evaluableList.add(Evaluable.get(escapeFormatString(x.BackTextFormat().getText())));
                } else if (x.BackStringFormatSquare() != null) {
                    stringFormatExpr.evaluableList.add(new BackStringFormatSquareExpr(
                            x.BackStringFormatSquare().getText(), options == null ? null : options.squareFunctionName));
                } else if (x.BackIdInterp() != null) {
                    stringFormatExpr.evaluableList.add(new IdExpr(x.BackIdInterp().getText().substring(1))); // skip $
                } else {
                    stringFormatExpr.evaluableList.add(translate(maContext, x.singleExpr()));
                }
            });
            return stringFormatExpr;
        }

        if (context instanceof MaScriptParser.StatsContext) {
            MaScriptParser.StatsContext c = (MaScriptParser.StatsContext) context;
            StatsStat stat = new StatsStat();
            c.stat().forEach(x -> stat.list.add(translate(maContext, x)));
            return stat;
        }

        // program
        if (context instanceof MaScriptParser.ProgramContext) {
            MaScriptParser.ProgramContext c = (MaScriptParser.ProgramContext) context;
            Program program = new Program();
            if (c.stats() != null) {
                c.stats().stat().forEach(x -> program.list.add(translate(maContext, x)));
            }
            return program;
        }
        errorListener.errorCount++;
        errorListener.messageBuilder.append("[ERROR] unrecognized class ").append(context.getClass().getName());
        System.out.println("ERROR, unrecognized class " + context.getClass().getName());
        return Evaluable.Null;
    }

    ErrorListener errorListener = new ErrorListener();
    private Evaluable program = null;
    private String src;
    private MaCompileOptions options = null;

    public void setCompileOptions(MaCompileOptions options) {
        this.options = options;
    }

    public MaCompileResult compile(String script) {
        return compile(null, script);
    }

    public MaCompileResult compile(MaContext context, String script) {
        MaCompileResult maResult = new MaCompileResult();
        errorListener.reset();
        this.src = script;
        if (script == null || script.isEmpty()) {
            maResult.warn = 1;
            maResult.message = "the script is empty";
        } else {
            MaScriptLexer maScriptLexer = new MaScriptLexer(CharStreams.fromString(script));
            maScriptLexer.addErrorListener(errorListener);
            CommonTokenStream commonTokenStream = new CommonTokenStream(maScriptLexer);
            MaScriptParser maScriptParser = new MaScriptParser(commonTokenStream);
            maScriptParser.addErrorListener(errorListener);
            MaScriptParser.ProgramContext programContext = maScriptParser.program();
            if (errorListener.errorCount == 0) {
                program = translate(context, programContext);
            }
            maResult.error = errorListener.errorCount;
            maResult.warn = errorListener.warningCount;
            maResult.message = errorListener.getErrorMsg();
        }
        return maResult;
    }

    public Object run(MaContext context) {
        if (program == null) {
            return null;
        }
        context.flowState = MaContext.FlowOrder;
        return program.eval(context);
    }

    public String getSrc() {
        return src;
    }
}
