// Generated from /home/mabaiming/work/src/ai/ma-script/src/main/resources/MaScriptParser.g4 by ANTLR 4.7.1
package com.xiaoming.script.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MaScriptParser}.
 */
public interface MaScriptParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#sep}.
	 * @param ctx the parse tree
	 */
	void enterSep(MaScriptParser.SepContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#sep}.
	 * @param ctx the parse tree
	 */
	void exitSep(MaScriptParser.SepContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(MaScriptParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(MaScriptParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(MaScriptParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(MaScriptParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(MaScriptParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(MaScriptParser.IdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MaScriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MaScriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#stats}.
	 * @param ctx the parse tree
	 */
	void enterStats(MaScriptParser.StatsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#stats}.
	 * @param ctx the parse tree
	 */
	void exitStats(MaScriptParser.StatsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(MaScriptParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(MaScriptParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterVarStat(MaScriptParser.VarStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitVarStat(MaScriptParser.VarStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MaScriptParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MaScriptParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForItStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterForItStat(MaScriptParser.ForItStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForItStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitForItStat(MaScriptParser.ForItStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterForInStat(MaScriptParser.ForInStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitForInStat(MaScriptParser.ForInStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(MaScriptParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(MaScriptParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(MaScriptParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(MaScriptParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinuekStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterContinuekStat(MaScriptParser.ContinuekStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinuekStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitContinuekStat(MaScriptParser.ContinuekStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDefStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefStat(MaScriptParser.FuncDefStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDefStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefStat(MaScriptParser.FuncDefStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprsStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprsStat(MaScriptParser.ExprsStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprsStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprsStat(MaScriptParser.ExprsStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStat(MaScriptParser.EmptyStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStat}
	 * labeled alternative in {@link MaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStat(MaScriptParser.EmptyStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#lambdaParam}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParam(MaScriptParser.LambdaParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#lambdaParam}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParam(MaScriptParser.LambdaParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(MaScriptParser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(MaScriptParser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(MaScriptParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(MaScriptParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#stringFormatPart}.
	 * @param ctx the parse tree
	 */
	void enterStringFormatPart(MaScriptParser.StringFormatPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#stringFormatPart}.
	 * @param ctx the parse tree
	 */
	void exitStringFormatPart(MaScriptParser.StringFormatPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MaScriptParser#backStringFormatPart}.
	 * @param ctx the parse tree
	 */
	void enterBackStringFormatPart(MaScriptParser.BackStringFormatPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MaScriptParser#backStringFormatPart}.
	 * @param ctx the parse tree
	 */
	void exitBackStringFormatPart(MaScriptParser.BackStringFormatPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(MaScriptParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(MaScriptParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(MaScriptParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(MaScriptParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(MaScriptParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(MaScriptParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDefExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefExpr(MaScriptParser.FuncDefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDefExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefExpr(MaScriptParser.FuncDefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterFloatExpr(MaScriptParser.FloatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitFloatExpr(MaScriptParser.FloatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code triStringFormatExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterTriStringFormatExpr(MaScriptParser.TriStringFormatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code triStringFormatExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitTriStringFormatExpr(MaScriptParser.TriStringFormatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncMemberIndexExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterIncMemberIndexExpr(MaScriptParser.IncMemberIndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncMemberIndexExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitIncMemberIndexExpr(MaScriptParser.IncMemberIndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PriorityExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterPriorityExpr(MaScriptParser.PriorityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PriorityExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitPriorityExpr(MaScriptParser.PriorityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberIndexExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberIndexExpr(MaScriptParser.MemberIndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberIndexExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberIndexExpr(MaScriptParser.MemberIndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncIdExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterIncIdExpr(MaScriptParser.IncIdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncIdExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitIncIdExpr(MaScriptParser.IncIdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterNullExpr(MaScriptParser.NullExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitNullExpr(MaScriptParser.NullExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdIncExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdIncExpr(MaScriptParser.IdIncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdIncExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdIncExpr(MaScriptParser.IdIncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberDotExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberDotExpr(MaScriptParser.MemberDotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberDotExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberDotExpr(MaScriptParser.MemberDotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAssignExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterExprAssignExpr(MaScriptParser.ExprAssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAssignExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitExprAssignExpr(MaScriptParser.ExprAssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterObjectExpr(MaScriptParser.ObjectExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitObjectExpr(MaScriptParser.ObjectExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberDotAssignAppendExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberDotAssignAppendExpr(MaScriptParser.MemberDotAssignAppendExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberDotAssignAppendExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberDotAssignAppendExpr(MaScriptParser.MemberDotAssignAppendExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringFormatExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringFormatExpr(MaScriptParser.StringFormatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringFormatExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringFormatExpr(MaScriptParser.StringFormatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberDotIncExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberDotIncExpr(MaScriptParser.MemberDotIncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberDotIncExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberDotIncExpr(MaScriptParser.MemberDotIncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(MaScriptParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(MaScriptParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberIndexAssignAppendExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberIndexAssignAppendExpr(MaScriptParser.MemberIndexAssignAppendExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberIndexAssignAppendExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberIndexAssignAppendExpr(MaScriptParser.MemberIndexAssignAppendExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TernaryExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(MaScriptParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TernaryExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(MaScriptParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(MaScriptParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(MaScriptParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(MaScriptParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(MaScriptParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberIndexAssignExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberIndexAssignExpr(MaScriptParser.MemberIndexAssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberIndexAssignExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberIndexAssignExpr(MaScriptParser.MemberIndexAssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(MaScriptParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(MaScriptParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberIndexIncExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberIndexIncExpr(MaScriptParser.MemberIndexIncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberIndexIncExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberIndexIncExpr(MaScriptParser.MemberIndexIncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(MaScriptParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(MaScriptParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpr(MaScriptParser.RelationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpr(MaScriptParser.RelationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdAssignAppendExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdAssignAppendExpr(MaScriptParser.IdAssignAppendExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdAssignAppendExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdAssignAppendExpr(MaScriptParser.IdAssignAppendExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(MaScriptParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(MaScriptParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberFuncCallExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberFuncCallExpr(MaScriptParser.MemberFuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberFuncCallExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberFuncCallExpr(MaScriptParser.MemberFuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(MaScriptParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(MaScriptParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LambdaDefExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterLambdaDefExpr(MaScriptParser.LambdaDefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LambdaDefExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitLambdaDefExpr(MaScriptParser.LambdaDefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdAssignExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdAssignExpr(MaScriptParser.IdAssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdAssignExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdAssignExpr(MaScriptParser.IdAssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(MaScriptParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(MaScriptParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncMemberDotExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterIncMemberDotExpr(MaScriptParser.IncMemberDotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncMemberDotExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitIncMemberDotExpr(MaScriptParser.IncMemberDotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(MaScriptParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(MaScriptParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberDotAssignExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberDotAssignExpr(MaScriptParser.MemberDotAssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberDotAssignExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberDotAssignExpr(MaScriptParser.MemberDotAssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinusExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(MaScriptParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinusExpr}
	 * labeled alternative in {@link MaScriptParser#singleExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(MaScriptParser.UnaryMinusExprContext ctx);
}