// Generated from /home/mabaiming/work/src/ai/ma-script/src/main/resources/MaScriptParser.g4 by ANTLR 4.7.1
package com.xiaoming.script.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MaScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LinesComment=1, LineComment=2, Null=3, Bool=4, Int=5, Float=6, String=7, 
		BackStringFormatOpen=8, StringFormatOpen=9, WS=10, WhiteSpaces=11, LineEnd=12, 
		Not=13, Mult=14, Add=15, Relation=16, Eq=17, AssignAppend=18, Inc=19, 
		And=20, Or=21, Query=22, SquareOpen=23, SquareClose=24, Dot=25, Assign=26, 
		BlockOpen=27, BlockClose=28, ParenOpen=29, ParenClose=30, Colon=31, Comma=32, 
		Semicolon=33, Arrow=34, Var=35, Function=36, Return=37, If=38, Else=39, 
		For=40, Break=41, Continue=42, Id=43, StringFormatClose=44, IdInterp=45, 
		ExprInterpOpen=46, TextFormat=47, BackStringFormatClose=48, BackIdInterp=49, 
		BackExprInterpOpen=50, BackStringFormatSquare=51, BackTextFormat=52;
	public static final int
		RULE_sep = 0, RULE_array = 1, RULE_object = 2, RULE_ids = 3, RULE_program = 4, 
		RULE_stats = 5, RULE_stat = 6, RULE_lambdaParam = 7, RULE_lambdaBody = 8, 
		RULE_exprs = 9, RULE_stringFormatPart = 10, RULE_backStringFormatPart = 11, 
		RULE_singleExpr = 12;
	public static final String[] ruleNames = {
		"sep", "array", "object", "ids", "program", "stats", "stat", "lambdaParam", 
		"lambdaBody", "exprs", "stringFormatPart", "backStringFormatPart", "singleExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'null'", null, null, null, null, "'s`'", "'s\"'", null, 
		null, null, null, null, null, null, null, null, null, null, null, "'?'", 
		"'['", "']'", "'.'", "'='", "'{'", "'}'", "'('", "')'", "':'", "','", 
		"';'", "'->'", "'var'", "'function'", "'return'", "'if'", "'else'", "'for'", 
		"'break'", "'continue'", null, "'\"'", null, null, null, "'`'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LinesComment", "LineComment", "Null", "Bool", "Int", "Float", "String", 
		"BackStringFormatOpen", "StringFormatOpen", "WS", "WhiteSpaces", "LineEnd", 
		"Not", "Mult", "Add", "Relation", "Eq", "AssignAppend", "Inc", "And", 
		"Or", "Query", "SquareOpen", "SquareClose", "Dot", "Assign", "BlockOpen", 
		"BlockClose", "ParenOpen", "ParenClose", "Colon", "Comma", "Semicolon", 
		"Arrow", "Var", "Function", "Return", "If", "Else", "For", "Break", "Continue", 
		"Id", "StringFormatClose", "IdInterp", "ExprInterpOpen", "TextFormat", 
		"BackStringFormatClose", "BackIdInterp", "BackExprInterpOpen", "BackStringFormatSquare", 
		"BackTextFormat"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MaScriptParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MaScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SepContext extends ParserRuleContext {
		public TerminalNode Semicolon() { return getToken(MaScriptParser.Semicolon, 0); }
		public TerminalNode EOF() { return getToken(MaScriptParser.EOF, 0); }
		public SepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterSep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitSep(this);
		}
	}

	public final SepContext sep() throws RecognitionException {
		SepContext _localctx = new SepContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==Semicolon) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode SquareOpen() { return getToken(MaScriptParser.SquareOpen, 0); }
		public TerminalNode SquareClose() { return getToken(MaScriptParser.SquareClose, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(SquareOpen);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Function) | (1L << Id))) != 0)) {
				{
				setState(29);
				exprs();
				}
			}

			setState(32);
			match(SquareClose);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectContext extends ParserRuleContext {
		public TerminalNode BlockOpen() { return getToken(MaScriptParser.BlockOpen, 0); }
		public List<TerminalNode> Id() { return getTokens(MaScriptParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(MaScriptParser.Id, i);
		}
		public List<TerminalNode> Colon() { return getTokens(MaScriptParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(MaScriptParser.Colon, i);
		}
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode BlockClose() { return getToken(MaScriptParser.BlockClose, 0); }
		public List<TerminalNode> Comma() { return getTokens(MaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MaScriptParser.Comma, i);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_object);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(BlockOpen);
			setState(35);
			match(Id);
			setState(36);
			match(Colon);
			setState(37);
			singleExpr(0);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					match(Comma);
					setState(39);
					match(Id);
					setState(40);
					match(Colon);
					setState(41);
					singleExpr(0);
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(47);
				match(Comma);
				}
			}

			setState(50);
			match(BlockClose);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdsContext extends ParserRuleContext {
		public List<TerminalNode> Id() { return getTokens(MaScriptParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(MaScriptParser.Id, i);
		}
		public List<TerminalNode> Comma() { return getTokens(MaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MaScriptParser.Comma, i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIds(this);
		}
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(Id);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(53);
				match(Comma);
				setState(54);
				match(Id);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MaScriptParser.EOF, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Semicolon) | (1L << Var) | (1L << Function) | (1L << Return) | (1L << If) | (1L << For) | (1L << Break) | (1L << Continue) | (1L << Id))) != 0)) {
				{
				setState(60);
				stats();
				}
			}

			setState(63);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatsContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public StatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stats; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterStats(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitStats(this);
		}
	}

	public final StatsContext stats() throws RecognitionException {
		StatsContext _localctx = new StatsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				stat();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Semicolon) | (1L << Var) | (1L << Function) | (1L << Return) | (1L << If) | (1L << For) | (1L << Break) | (1L << Continue) | (1L << Id))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarStatContext extends StatContext {
		public TerminalNode Var() { return getToken(MaScriptParser.Var, 0); }
		public List<TerminalNode> Id() { return getTokens(MaScriptParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(MaScriptParser.Id, i);
		}
		public List<TerminalNode> Assign() { return getTokens(MaScriptParser.Assign); }
		public TerminalNode Assign(int i) {
			return getToken(MaScriptParser.Assign, i);
		}
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(MaScriptParser.Semicolon, 0); }
		public List<TerminalNode> Comma() { return getTokens(MaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MaScriptParser.Comma, i);
		}
		public VarStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterVarStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitVarStat(this);
		}
	}
	public static class ReturnStatContext extends StatContext {
		public TerminalNode Return() { return getToken(MaScriptParser.Return, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public ReturnStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitReturnStat(this);
		}
	}
	public static class BreakStatContext extends StatContext {
		public TerminalNode Break() { return getToken(MaScriptParser.Break, 0); }
		public TerminalNode Semicolon() { return getToken(MaScriptParser.Semicolon, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitBreakStat(this);
		}
	}
	public static class BlockStatContext extends StatContext {
		public TerminalNode BlockOpen() { return getToken(MaScriptParser.BlockOpen, 0); }
		public TerminalNode BlockClose() { return getToken(MaScriptParser.BlockClose, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitBlockStat(this);
		}
	}
	public static class ForItStatContext extends StatContext {
		public TerminalNode For() { return getToken(MaScriptParser.For, 0); }
		public TerminalNode ParenOpen() { return getToken(MaScriptParser.ParenOpen, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode Assign() { return getToken(MaScriptParser.Assign, 0); }
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public List<TerminalNode> Semicolon() { return getTokens(MaScriptParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(MaScriptParser.Semicolon, i);
		}
		public TerminalNode ParenClose() { return getToken(MaScriptParser.ParenClose, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode Var() { return getToken(MaScriptParser.Var, 0); }
		public ForItStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterForItStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitForItStat(this);
		}
	}
	public static class ForInStatContext extends StatContext {
		public TerminalNode For() { return getToken(MaScriptParser.For, 0); }
		public TerminalNode ParenOpen() { return getToken(MaScriptParser.ParenOpen, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode Colon() { return getToken(MaScriptParser.Colon, 0); }
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode ParenClose() { return getToken(MaScriptParser.ParenClose, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode Var() { return getToken(MaScriptParser.Var, 0); }
		public ForInStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterForInStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitForInStat(this);
		}
	}
	public static class ContinuekStatContext extends StatContext {
		public TerminalNode Continue() { return getToken(MaScriptParser.Continue, 0); }
		public TerminalNode Semicolon() { return getToken(MaScriptParser.Semicolon, 0); }
		public ContinuekStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterContinuekStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitContinuekStat(this);
		}
	}
	public static class IfStatContext extends StatContext {
		public TerminalNode If() { return getToken(MaScriptParser.If, 0); }
		public TerminalNode ParenOpen() { return getToken(MaScriptParser.ParenOpen, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode ParenClose() { return getToken(MaScriptParser.ParenClose, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode Else() { return getToken(MaScriptParser.Else, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIfStat(this);
		}
	}
	public static class ExprsStatContext extends StatContext {
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public ExprsStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterExprsStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitExprsStat(this);
		}
	}
	public static class FuncDefStatContext extends StatContext {
		public TerminalNode Function() { return getToken(MaScriptParser.Function, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode ParenOpen() { return getToken(MaScriptParser.ParenOpen, 0); }
		public TerminalNode ParenClose() { return getToken(MaScriptParser.ParenClose, 0); }
		public TerminalNode BlockOpen() { return getToken(MaScriptParser.BlockOpen, 0); }
		public TerminalNode BlockClose() { return getToken(MaScriptParser.BlockClose, 0); }
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public FuncDefStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterFuncDefStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitFuncDefStat(this);
		}
	}
	public static class EmptyStatContext extends StatContext {
		public TerminalNode Semicolon() { return getToken(MaScriptParser.Semicolon, 0); }
		public EmptyStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterEmptyStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitEmptyStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stat);
		int _la;
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(BlockOpen);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Semicolon) | (1L << Var) | (1L << Function) | (1L << Return) | (1L << If) | (1L << For) | (1L << Break) | (1L << Continue) | (1L << Id))) != 0)) {
					{
					setState(71);
					stats();
					}
				}

				setState(74);
				match(BlockClose);
				}
				break;
			case 2:
				_localctx = new VarStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(Var);
				setState(76);
				match(Id);
				setState(77);
				match(Assign);
				setState(78);
				singleExpr(0);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(79);
					match(Comma);
					setState(80);
					match(Id);
					setState(81);
					match(Assign);
					setState(82);
					singleExpr(0);
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(88);
				match(Semicolon);
				}
				break;
			case 3:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(If);
				setState(91);
				match(ParenOpen);
				setState(92);
				exprs();
				setState(93);
				match(ParenClose);
				setState(94);
				stat();
				setState(97);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(95);
					match(Else);
					setState(96);
					stat();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ForItStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				match(For);
				setState(100);
				match(ParenOpen);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Var) {
					{
					setState(101);
					match(Var);
					}
				}

				setState(104);
				match(Id);
				setState(105);
				match(Assign);
				setState(106);
				singleExpr(0);
				setState(107);
				match(Semicolon);
				setState(108);
				singleExpr(0);
				setState(109);
				match(Semicolon);
				setState(110);
				singleExpr(0);
				setState(111);
				match(ParenClose);
				setState(112);
				stat();
				}
				break;
			case 5:
				_localctx = new ForInStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(114);
				match(For);
				setState(115);
				match(ParenOpen);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Var) {
					{
					setState(116);
					match(Var);
					}
				}

				setState(119);
				match(Id);
				setState(120);
				match(Colon);
				setState(121);
				singleExpr(0);
				setState(122);
				match(ParenClose);
				setState(123);
				stat();
				}
				break;
			case 6:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(125);
				match(Return);
				setState(127);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(126);
					exprs();
					}
					break;
				}
				setState(130);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(129);
					sep();
					}
					break;
				}
				}
				break;
			case 7:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(132);
				match(Break);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Function) | (1L << Id))) != 0)) {
					{
					setState(133);
					exprs();
					}
				}

				setState(136);
				match(Semicolon);
				}
				break;
			case 8:
				_localctx = new ContinuekStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(137);
				match(Continue);
				setState(138);
				match(Semicolon);
				}
				break;
			case 9:
				_localctx = new FuncDefStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(139);
				match(Function);
				setState(140);
				match(Id);
				setState(141);
				match(ParenOpen);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Id) {
					{
					setState(142);
					ids();
					}
				}

				setState(145);
				match(ParenClose);
				setState(146);
				match(BlockOpen);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Semicolon) | (1L << Var) | (1L << Function) | (1L << Return) | (1L << If) | (1L << For) | (1L << Break) | (1L << Continue) | (1L << Id))) != 0)) {
					{
					setState(147);
					stats();
					}
				}

				setState(150);
				match(BlockClose);
				}
				break;
			case 10:
				_localctx = new ExprsStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(151);
				exprs();
				setState(152);
				sep();
				}
				break;
			case 11:
				_localctx = new EmptyStatContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(154);
				match(Semicolon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaParamContext extends ParserRuleContext {
		public List<TerminalNode> Id() { return getTokens(MaScriptParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(MaScriptParser.Id, i);
		}
		public TerminalNode ParenOpen() { return getToken(MaScriptParser.ParenOpen, 0); }
		public TerminalNode ParenClose() { return getToken(MaScriptParser.ParenClose, 0); }
		public List<TerminalNode> Comma() { return getTokens(MaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MaScriptParser.Comma, i);
		}
		public LambdaParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterLambdaParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitLambdaParam(this);
		}
	}

	public final LambdaParamContext lambdaParam() throws RecognitionException {
		LambdaParamContext _localctx = new LambdaParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lambdaParam);
		int _la;
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(157);
					match(Id);
					}
					}
					setState(160); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Id );
				}
				break;
			case ParenOpen:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(ParenOpen);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Id) {
					{
					{
					setState(163);
					match(Id);
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(164);
						match(Comma);
						}
					}

					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(172);
				match(ParenClose);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaBodyContext extends ParserRuleContext {
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode BlockOpen() { return getToken(MaScriptParser.BlockOpen, 0); }
		public TerminalNode BlockClose() { return getToken(MaScriptParser.BlockClose, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public LambdaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterLambdaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitLambdaBody(this);
		}
	}

	public final LambdaBodyContext lambdaBody() throws RecognitionException {
		LambdaBodyContext _localctx = new LambdaBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lambdaBody);
		int _la;
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				exprs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(BlockOpen);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Semicolon) | (1L << Var) | (1L << Function) | (1L << Return) | (1L << If) | (1L << For) | (1L << Break) | (1L << Continue) | (1L << Id))) != 0)) {
					{
					setState(177);
					stats();
					}
				}

				setState(180);
				match(BlockClose);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprsContext extends ParserRuleContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MaScriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MaScriptParser.Comma, i);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitExprs(this);
		}
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_exprs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			singleExpr(0);
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(184);
					match(Comma);
					setState(185);
					singleExpr(0);
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringFormatPartContext extends ParserRuleContext {
		public TerminalNode TextFormat() { return getToken(MaScriptParser.TextFormat, 0); }
		public TerminalNode IdInterp() { return getToken(MaScriptParser.IdInterp, 0); }
		public TerminalNode ExprInterpOpen() { return getToken(MaScriptParser.ExprInterpOpen, 0); }
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode BlockClose() { return getToken(MaScriptParser.BlockClose, 0); }
		public StringFormatPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringFormatPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterStringFormatPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitStringFormatPart(this);
		}
	}

	public final StringFormatPartContext stringFormatPart() throws RecognitionException {
		StringFormatPartContext _localctx = new StringFormatPartContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stringFormatPart);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TextFormat:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(TextFormat);
				}
				break;
			case IdInterp:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(IdInterp);
				}
				break;
			case ExprInterpOpen:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				match(ExprInterpOpen);
				setState(194);
				singleExpr(0);
				setState(195);
				match(BlockClose);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BackStringFormatPartContext extends ParserRuleContext {
		public TerminalNode BackStringFormatSquare() { return getToken(MaScriptParser.BackStringFormatSquare, 0); }
		public TerminalNode BackTextFormat() { return getToken(MaScriptParser.BackTextFormat, 0); }
		public TerminalNode BackIdInterp() { return getToken(MaScriptParser.BackIdInterp, 0); }
		public TerminalNode BackExprInterpOpen() { return getToken(MaScriptParser.BackExprInterpOpen, 0); }
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode BlockClose() { return getToken(MaScriptParser.BlockClose, 0); }
		public BackStringFormatPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_backStringFormatPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterBackStringFormatPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitBackStringFormatPart(this);
		}
	}

	public final BackStringFormatPartContext backStringFormatPart() throws RecognitionException {
		BackStringFormatPartContext _localctx = new BackStringFormatPartContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_backStringFormatPart);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BackStringFormatSquare:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(BackStringFormatSquare);
				}
				break;
			case BackTextFormat:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(BackTextFormat);
				}
				break;
			case BackIdInterp:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(BackIdInterp);
				}
				break;
			case BackExprInterpOpen:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				match(BackExprInterpOpen);
				setState(203);
				singleExpr(0);
				setState(204);
				match(BlockClose);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleExprContext extends ParserRuleContext {
		public SingleExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleExpr; }
	 
		public SingleExprContext() { }
		public void copyFrom(SingleExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode And() { return getToken(MaScriptParser.And, 0); }
		public AndExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitAndExpr(this);
		}
	}
	public static class BoolExprContext extends SingleExprContext {
		public TerminalNode Bool() { return getToken(MaScriptParser.Bool, 0); }
		public BoolExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitBoolExpr(this);
		}
	}
	public static class StringExprContext extends SingleExprContext {
		public TerminalNode String() { return getToken(MaScriptParser.String, 0); }
		public StringExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitStringExpr(this);
		}
	}
	public static class FuncDefExprContext extends SingleExprContext {
		public TerminalNode Function() { return getToken(MaScriptParser.Function, 0); }
		public TerminalNode ParenOpen() { return getToken(MaScriptParser.ParenOpen, 0); }
		public TerminalNode ParenClose() { return getToken(MaScriptParser.ParenClose, 0); }
		public TerminalNode BlockOpen() { return getToken(MaScriptParser.BlockOpen, 0); }
		public TerminalNode BlockClose() { return getToken(MaScriptParser.BlockClose, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public FuncDefExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterFuncDefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitFuncDefExpr(this);
		}
	}
	public static class FloatExprContext extends SingleExprContext {
		public TerminalNode Float() { return getToken(MaScriptParser.Float, 0); }
		public FloatExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterFloatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitFloatExpr(this);
		}
	}
	public static class TriStringFormatExprContext extends SingleExprContext {
		public TerminalNode BackStringFormatOpen() { return getToken(MaScriptParser.BackStringFormatOpen, 0); }
		public TerminalNode BackStringFormatClose() { return getToken(MaScriptParser.BackStringFormatClose, 0); }
		public List<BackStringFormatPartContext> backStringFormatPart() {
			return getRuleContexts(BackStringFormatPartContext.class);
		}
		public BackStringFormatPartContext backStringFormatPart(int i) {
			return getRuleContext(BackStringFormatPartContext.class,i);
		}
		public TriStringFormatExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterTriStringFormatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitTriStringFormatExpr(this);
		}
	}
	public static class IncMemberIndexExprContext extends SingleExprContext {
		public TerminalNode Inc() { return getToken(MaScriptParser.Inc, 0); }
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode SquareOpen() { return getToken(MaScriptParser.SquareOpen, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode SquareClose() { return getToken(MaScriptParser.SquareClose, 0); }
		public IncMemberIndexExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIncMemberIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIncMemberIndexExpr(this);
		}
	}
	public static class PriorityExprContext extends SingleExprContext {
		public TerminalNode ParenOpen() { return getToken(MaScriptParser.ParenOpen, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode ParenClose() { return getToken(MaScriptParser.ParenClose, 0); }
		public PriorityExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterPriorityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitPriorityExpr(this);
		}
	}
	public static class MemberIndexExprContext extends SingleExprContext {
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode SquareOpen() { return getToken(MaScriptParser.SquareOpen, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode SquareClose() { return getToken(MaScriptParser.SquareClose, 0); }
		public MemberIndexExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMemberIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMemberIndexExpr(this);
		}
	}
	public static class IncIdExprContext extends SingleExprContext {
		public TerminalNode Inc() { return getToken(MaScriptParser.Inc, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public IncIdExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIncIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIncIdExpr(this);
		}
	}
	public static class NullExprContext extends SingleExprContext {
		public TerminalNode Null() { return getToken(MaScriptParser.Null, 0); }
		public NullExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterNullExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitNullExpr(this);
		}
	}
	public static class IdIncExprContext extends SingleExprContext {
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode Inc() { return getToken(MaScriptParser.Inc, 0); }
		public IdIncExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIdIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIdIncExpr(this);
		}
	}
	public static class MemberDotExprContext extends SingleExprContext {
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode Dot() { return getToken(MaScriptParser.Dot, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public MemberDotExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMemberDotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMemberDotExpr(this);
		}
	}
	public static class ExprAssignExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Assign() { return getToken(MaScriptParser.Assign, 0); }
		public ExprAssignExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterExprAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitExprAssignExpr(this);
		}
	}
	public static class ObjectExprContext extends SingleExprContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ObjectExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterObjectExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitObjectExpr(this);
		}
	}
	public static class MemberDotAssignAppendExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Dot() { return getToken(MaScriptParser.Dot, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode AssignAppend() { return getToken(MaScriptParser.AssignAppend, 0); }
		public MemberDotAssignAppendExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMemberDotAssignAppendExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMemberDotAssignAppendExpr(this);
		}
	}
	public static class StringFormatExprContext extends SingleExprContext {
		public TerminalNode StringFormatOpen() { return getToken(MaScriptParser.StringFormatOpen, 0); }
		public TerminalNode StringFormatClose() { return getToken(MaScriptParser.StringFormatClose, 0); }
		public List<StringFormatPartContext> stringFormatPart() {
			return getRuleContexts(StringFormatPartContext.class);
		}
		public StringFormatPartContext stringFormatPart(int i) {
			return getRuleContext(StringFormatPartContext.class,i);
		}
		public StringFormatExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterStringFormatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitStringFormatExpr(this);
		}
	}
	public static class MemberDotIncExprContext extends SingleExprContext {
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode Dot() { return getToken(MaScriptParser.Dot, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode Inc() { return getToken(MaScriptParser.Inc, 0); }
		public MemberDotIncExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMemberDotIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMemberDotIncExpr(this);
		}
	}
	public static class NotExprContext extends SingleExprContext {
		public TerminalNode Not() { return getToken(MaScriptParser.Not, 0); }
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public NotExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitNotExpr(this);
		}
	}
	public static class MemberIndexAssignAppendExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode SquareOpen() { return getToken(MaScriptParser.SquareOpen, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode SquareClose() { return getToken(MaScriptParser.SquareClose, 0); }
		public TerminalNode AssignAppend() { return getToken(MaScriptParser.AssignAppend, 0); }
		public MemberIndexAssignAppendExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMemberIndexAssignAppendExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMemberIndexAssignAppendExpr(this);
		}
	}
	public static class TernaryExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Query() { return getToken(MaScriptParser.Query, 0); }
		public TerminalNode Colon() { return getToken(MaScriptParser.Colon, 0); }
		public TernaryExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterTernaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitTernaryExpr(this);
		}
	}
	public static class FuncCallExprContext extends SingleExprContext {
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode ParenOpen() { return getToken(MaScriptParser.ParenOpen, 0); }
		public TerminalNode ParenClose() { return getToken(MaScriptParser.ParenClose, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public FuncCallExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitFuncCallExpr(this);
		}
	}
	public static class IdExprContext extends SingleExprContext {
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public IdExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIdExpr(this);
		}
	}
	public static class MemberIndexAssignExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode SquareOpen() { return getToken(MaScriptParser.SquareOpen, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode SquareClose() { return getToken(MaScriptParser.SquareClose, 0); }
		public TerminalNode Assign() { return getToken(MaScriptParser.Assign, 0); }
		public MemberIndexAssignExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMemberIndexAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMemberIndexAssignExpr(this);
		}
	}
	public static class MultExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Mult() { return getToken(MaScriptParser.Mult, 0); }
		public MultExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMultExpr(this);
		}
	}
	public static class MemberIndexIncExprContext extends SingleExprContext {
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode SquareOpen() { return getToken(MaScriptParser.SquareOpen, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode SquareClose() { return getToken(MaScriptParser.SquareClose, 0); }
		public TerminalNode Inc() { return getToken(MaScriptParser.Inc, 0); }
		public MemberIndexIncExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMemberIndexIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMemberIndexIncExpr(this);
		}
	}
	public static class AddExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Add() { return getToken(MaScriptParser.Add, 0); }
		public AddExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitAddExpr(this);
		}
	}
	public static class RelationExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Relation() { return getToken(MaScriptParser.Relation, 0); }
		public RelationExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterRelationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitRelationExpr(this);
		}
	}
	public static class IdAssignAppendExprContext extends SingleExprContext {
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode AssignAppend() { return getToken(MaScriptParser.AssignAppend, 0); }
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public IdAssignAppendExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIdAssignAppendExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIdAssignAppendExpr(this);
		}
	}
	public static class OrExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Or() { return getToken(MaScriptParser.Or, 0); }
		public OrExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitOrExpr(this);
		}
	}
	public static class MemberFuncCallExprContext extends SingleExprContext {
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode Dot() { return getToken(MaScriptParser.Dot, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode ParenOpen() { return getToken(MaScriptParser.ParenOpen, 0); }
		public TerminalNode ParenClose() { return getToken(MaScriptParser.ParenClose, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public MemberFuncCallExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMemberFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMemberFuncCallExpr(this);
		}
	}
	public static class ArrayExprContext extends SingleExprContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitArrayExpr(this);
		}
	}
	public static class LambdaDefExprContext extends SingleExprContext {
		public LambdaParamContext lambdaParam() {
			return getRuleContext(LambdaParamContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(MaScriptParser.Arrow, 0); }
		public LambdaBodyContext lambdaBody() {
			return getRuleContext(LambdaBodyContext.class,0);
		}
		public LambdaDefExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterLambdaDefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitLambdaDefExpr(this);
		}
	}
	public static class IdAssignExprContext extends SingleExprContext {
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode Assign() { return getToken(MaScriptParser.Assign, 0); }
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public IdAssignExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIdAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIdAssignExpr(this);
		}
	}
	public static class EqExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Eq() { return getToken(MaScriptParser.Eq, 0); }
		public EqExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitEqExpr(this);
		}
	}
	public static class IncMemberDotExprContext extends SingleExprContext {
		public TerminalNode Inc() { return getToken(MaScriptParser.Inc, 0); }
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public TerminalNode Dot() { return getToken(MaScriptParser.Dot, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public IncMemberDotExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIncMemberDotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIncMemberDotExpr(this);
		}
	}
	public static class IntExprContext extends SingleExprContext {
		public TerminalNode Int() { return getToken(MaScriptParser.Int, 0); }
		public IntExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitIntExpr(this);
		}
	}
	public static class MemberDotAssignExprContext extends SingleExprContext {
		public List<SingleExprContext> singleExpr() {
			return getRuleContexts(SingleExprContext.class);
		}
		public SingleExprContext singleExpr(int i) {
			return getRuleContext(SingleExprContext.class,i);
		}
		public TerminalNode Dot() { return getToken(MaScriptParser.Dot, 0); }
		public TerminalNode Id() { return getToken(MaScriptParser.Id, 0); }
		public TerminalNode Assign() { return getToken(MaScriptParser.Assign, 0); }
		public MemberDotAssignExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterMemberDotAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitMemberDotAssignExpr(this);
		}
	}
	public static class UnaryMinusExprContext extends SingleExprContext {
		public TerminalNode Add() { return getToken(MaScriptParser.Add, 0); }
		public SingleExprContext singleExpr() {
			return getRuleContext(SingleExprContext.class,0);
		}
		public UnaryMinusExprContext(SingleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).enterUnaryMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MaScriptParserListener ) ((MaScriptParserListener)listener).exitUnaryMinusExpr(this);
		}
	}

	public final SingleExprContext singleExpr() throws RecognitionException {
		return singleExpr(0);
	}

	private SingleExprContext singleExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SingleExprContext _localctx = new SingleExprContext(_ctx, _parentState);
		SingleExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_singleExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new FuncDefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(209);
				match(Function);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Id) {
					{
					setState(210);
					match(Id);
					}
				}

				setState(213);
				match(ParenOpen);
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Id) {
					{
					setState(214);
					ids();
					}
				}

				setState(217);
				match(ParenClose);
				setState(218);
				match(BlockOpen);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Semicolon) | (1L << Var) | (1L << Function) | (1L << Return) | (1L << If) | (1L << For) | (1L << Break) | (1L << Continue) | (1L << Id))) != 0)) {
					{
					setState(219);
					stats();
					}
				}

				setState(222);
				match(BlockClose);
				}
				break;
			case 2:
				{
				_localctx = new LambdaDefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				lambdaParam();
				setState(224);
				match(Arrow);
				setState(225);
				lambdaBody();
				}
				break;
			case 3:
				{
				_localctx = new IdIncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(Id);
				setState(228);
				match(Inc);
				}
				break;
			case 4:
				{
				_localctx = new IncMemberIndexExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				match(Inc);
				setState(230);
				singleExpr(0);
				setState(231);
				match(SquareOpen);
				setState(232);
				exprs();
				setState(233);
				match(SquareClose);
				}
				break;
			case 5:
				{
				_localctx = new IncMemberDotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				match(Inc);
				setState(236);
				singleExpr(0);
				setState(237);
				match(Dot);
				setState(238);
				match(Id);
				}
				break;
			case 6:
				{
				_localctx = new IncIdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				match(Inc);
				setState(241);
				match(Id);
				}
				break;
			case 7:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				match(Add);
				setState(243);
				singleExpr(27);
				}
				break;
			case 8:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				match(Not);
				setState(245);
				singleExpr(26);
				}
				break;
			case 9:
				{
				_localctx = new IdAssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246);
				match(Id);
				setState(247);
				match(Assign);
				setState(248);
				singleExpr(21);
				}
				break;
			case 10:
				{
				_localctx = new IdAssignAppendExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				match(Id);
				setState(250);
				match(AssignAppend);
				setState(251);
				singleExpr(12);
				}
				break;
			case 11:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				match(Id);
				}
				break;
			case 12:
				{
				_localctx = new NullExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				match(Null);
				}
				break;
			case 13:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				match(Bool);
				}
				break;
			case 14:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(255);
				match(Int);
				}
				break;
			case 15:
				{
				_localctx = new FloatExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(Float);
				}
				break;
			case 16:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				match(String);
				}
				break;
			case 17:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				array();
				}
				break;
			case 18:
				{
				_localctx = new ObjectExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(259);
				object();
				}
				break;
			case 19:
				{
				_localctx = new PriorityExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260);
				match(ParenOpen);
				setState(261);
				exprs();
				setState(262);
				match(ParenClose);
				}
				break;
			case 20:
				{
				_localctx = new StringFormatExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				match(StringFormatOpen);
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IdInterp) | (1L << ExprInterpOpen) | (1L << TextFormat))) != 0)) {
					{
					{
					setState(265);
					stringFormatPart();
					}
					}
					setState(270);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(271);
				match(StringFormatClose);
				}
				break;
			case 21:
				{
				_localctx = new TriStringFormatExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				match(BackStringFormatOpen);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BackIdInterp) | (1L << BackExprInterpOpen) | (1L << BackStringFormatSquare) | (1L << BackTextFormat))) != 0)) {
					{
					{
					setState(273);
					backStringFormatPart();
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(279);
				match(BackStringFormatClose);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(367);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(365);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(282);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(283);
						match(Mult);
						setState(284);
						singleExpr(26);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(285);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(286);
						match(Add);
						setState(287);
						singleExpr(25);
						}
						break;
					case 3:
						{
						_localctx = new RelationExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(288);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(289);
						match(Relation);
						setState(290);
						singleExpr(24);
						}
						break;
					case 4:
						{
						_localctx = new EqExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(291);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(292);
						match(Eq);
						setState(293);
						singleExpr(23);
						}
						break;
					case 5:
						{
						_localctx = new MemberIndexAssignExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(294);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(295);
						match(SquareOpen);
						setState(296);
						exprs();
						setState(297);
						match(SquareClose);
						setState(298);
						match(Assign);
						setState(299);
						singleExpr(21);
						}
						break;
					case 6:
						{
						_localctx = new MemberDotAssignExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(301);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(302);
						match(Dot);
						setState(303);
						match(Id);
						setState(304);
						match(Assign);
						setState(305);
						singleExpr(20);
						}
						break;
					case 7:
						{
						_localctx = new ExprAssignExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(306);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(307);
						match(Assign);
						setState(308);
						singleExpr(19);
						}
						break;
					case 8:
						{
						_localctx = new AndExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(309);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(310);
						match(And);
						setState(311);
						singleExpr(18);
						}
						break;
					case 9:
						{
						_localctx = new OrExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(312);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(313);
						match(Or);
						setState(314);
						singleExpr(17);
						}
						break;
					case 10:
						{
						_localctx = new TernaryExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(315);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(316);
						match(Query);
						setState(317);
						singleExpr(0);
						setState(318);
						match(Colon);
						setState(319);
						singleExpr(16);
						}
						break;
					case 11:
						{
						_localctx = new MemberIndexAssignAppendExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(321);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(322);
						match(SquareOpen);
						setState(323);
						exprs();
						setState(324);
						match(SquareClose);
						setState(325);
						match(AssignAppend);
						setState(326);
						singleExpr(15);
						}
						break;
					case 12:
						{
						_localctx = new MemberDotAssignAppendExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(328);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(329);
						match(Dot);
						setState(330);
						match(Id);
						setState(331);
						match(AssignAppend);
						setState(332);
						singleExpr(14);
						}
						break;
					case 13:
						{
						_localctx = new MemberIndexExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(333);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(334);
						match(SquareOpen);
						setState(335);
						exprs();
						setState(336);
						match(SquareClose);
						}
						break;
					case 14:
						{
						_localctx = new MemberFuncCallExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(338);
						if (!(precpred(_ctx, 36))) throw new FailedPredicateException(this, "precpred(_ctx, 36)");
						setState(339);
						match(Dot);
						setState(340);
						match(Id);
						setState(341);
						match(ParenOpen);
						setState(343);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Function) | (1L << Id))) != 0)) {
							{
							setState(342);
							exprs();
							}
						}

						setState(345);
						match(ParenClose);
						}
						break;
					case 15:
						{
						_localctx = new MemberDotExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(346);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(347);
						match(Dot);
						setState(348);
						match(Id);
						}
						break;
					case 16:
						{
						_localctx = new FuncCallExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(349);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(350);
						match(ParenOpen);
						setState(352);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Bool) | (1L << Int) | (1L << Float) | (1L << String) | (1L << BackStringFormatOpen) | (1L << StringFormatOpen) | (1L << Not) | (1L << Add) | (1L << Inc) | (1L << SquareOpen) | (1L << BlockOpen) | (1L << ParenOpen) | (1L << Function) | (1L << Id))) != 0)) {
							{
							setState(351);
							exprs();
							}
						}

						setState(354);
						match(ParenClose);
						}
						break;
					case 17:
						{
						_localctx = new MemberIndexIncExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(355);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(356);
						match(SquareOpen);
						setState(357);
						exprs();
						setState(358);
						match(SquareClose);
						setState(359);
						match(Inc);
						}
						break;
					case 18:
						{
						_localctx = new MemberDotIncExprContext(new SingleExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpr);
						setState(361);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(362);
						match(Dot);
						setState(363);
						match(Id);
						setState(364);
						match(Inc);
						}
						break;
					}
					} 
				}
				setState(369);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return singleExpr_sempred((SingleExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean singleExpr_sempred(SingleExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 25);
		case 1:
			return precpred(_ctx, 24);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 22);
		case 4:
			return precpred(_ctx, 20);
		case 5:
			return precpred(_ctx, 19);
		case 6:
			return precpred(_ctx, 18);
		case 7:
			return precpred(_ctx, 17);
		case 8:
			return precpred(_ctx, 16);
		case 9:
			return precpred(_ctx, 15);
		case 10:
			return precpred(_ctx, 14);
		case 11:
			return precpred(_ctx, 13);
		case 12:
			return precpred(_ctx, 37);
		case 13:
			return precpred(_ctx, 36);
		case 14:
			return precpred(_ctx, 35);
		case 15:
			return precpred(_ctx, 34);
		case 16:
			return precpred(_ctx, 33);
		case 17:
			return precpred(_ctx, 32);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u0175\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\5\3!\n\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\4\5\4\63\n\4\3"+
		"\4\3\4\3\5\3\5\3\5\7\5:\n\5\f\5\16\5=\13\5\3\6\5\6@\n\6\3\6\3\6\3\7\6"+
		"\7E\n\7\r\7\16\7F\3\b\3\b\5\bK\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\bV\n\b\f\b\16\bY\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bd\n\b"+
		"\3\b\3\b\3\b\5\bi\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bx\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0082\n\b\3\b\5\b\u0085"+
		"\n\b\3\b\3\b\5\b\u0089\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0092\n\b\3"+
		"\b\3\b\3\b\5\b\u0097\n\b\3\b\3\b\3\b\3\b\3\b\5\b\u009e\n\b\3\t\6\t\u00a1"+
		"\n\t\r\t\16\t\u00a2\3\t\3\t\3\t\5\t\u00a8\n\t\7\t\u00aa\n\t\f\t\16\t\u00ad"+
		"\13\t\3\t\5\t\u00b0\n\t\3\n\3\n\3\n\5\n\u00b5\n\n\3\n\5\n\u00b8\n\n\3"+
		"\13\3\13\3\13\7\13\u00bd\n\13\f\13\16\13\u00c0\13\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u00c8\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d1\n\r\3\16\3"+
		"\16\3\16\5\16\u00d6\n\16\3\16\3\16\5\16\u00da\n\16\3\16\3\16\3\16\5\16"+
		"\u00df\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u010d\n\16\f\16\16\16\u0110\13\16\3\16\3\16"+
		"\3\16\7\16\u0115\n\16\f\16\16\16\u0118\13\16\3\16\5\16\u011b\n\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u015a\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0163\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u0170\n\16\f\16\16\16\u0173\13\16\3\16\2\3\32\17\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\2\3\3\3##\2\u01ba\2\34\3\2\2\2\4\36\3\2\2\2\6$\3\2"+
		"\2\2\b\66\3\2\2\2\n?\3\2\2\2\fD\3\2\2\2\16\u009d\3\2\2\2\20\u00af\3\2"+
		"\2\2\22\u00b7\3\2\2\2\24\u00b9\3\2\2\2\26\u00c7\3\2\2\2\30\u00d0\3\2\2"+
		"\2\32\u011a\3\2\2\2\34\35\t\2\2\2\35\3\3\2\2\2\36 \7\31\2\2\37!\5\24\13"+
		"\2 \37\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\7\32\2\2#\5\3\2\2\2$%\7\35\2\2"+
		"%&\7-\2\2&\'\7!\2\2\'.\5\32\16\2()\7\"\2\2)*\7-\2\2*+\7!\2\2+-\5\32\16"+
		"\2,(\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\61"+
		"\63\7\"\2\2\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\36\2\2\65"+
		"\7\3\2\2\2\66;\7-\2\2\678\7\"\2\28:\7-\2\29\67\3\2\2\2:=\3\2\2\2;9\3\2"+
		"\2\2;<\3\2\2\2<\t\3\2\2\2=;\3\2\2\2>@\5\f\7\2?>\3\2\2\2?@\3\2\2\2@A\3"+
		"\2\2\2AB\7\2\2\3B\13\3\2\2\2CE\5\16\b\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2"+
		"FG\3\2\2\2G\r\3\2\2\2HJ\7\35\2\2IK\5\f\7\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2"+
		"\2L\u009e\7\36\2\2MN\7%\2\2NO\7-\2\2OP\7\34\2\2PW\5\32\16\2QR\7\"\2\2"+
		"RS\7-\2\2ST\7\34\2\2TV\5\32\16\2UQ\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2"+
		"\2XZ\3\2\2\2YW\3\2\2\2Z[\7#\2\2[\u009e\3\2\2\2\\]\7(\2\2]^\7\37\2\2^_"+
		"\5\24\13\2_`\7 \2\2`c\5\16\b\2ab\7)\2\2bd\5\16\b\2ca\3\2\2\2cd\3\2\2\2"+
		"d\u009e\3\2\2\2ef\7*\2\2fh\7\37\2\2gi\7%\2\2hg\3\2\2\2hi\3\2\2\2ij\3\2"+
		"\2\2jk\7-\2\2kl\7\34\2\2lm\5\32\16\2mn\7#\2\2no\5\32\16\2op\7#\2\2pq\5"+
		"\32\16\2qr\7 \2\2rs\5\16\b\2s\u009e\3\2\2\2tu\7*\2\2uw\7\37\2\2vx\7%\2"+
		"\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7-\2\2z{\7!\2\2{|\5\32\16\2|}\7 \2"+
		"\2}~\5\16\b\2~\u009e\3\2\2\2\177\u0081\7\'\2\2\u0080\u0082\5\24\13\2\u0081"+
		"\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0085\5\2"+
		"\2\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u009e\3\2\2\2\u0086"+
		"\u0088\7+\2\2\u0087\u0089\5\24\13\2\u0088\u0087\3\2\2\2\u0088\u0089\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u009e\7#\2\2\u008b\u008c\7,\2\2\u008c"+
		"\u009e\7#\2\2\u008d\u008e\7&\2\2\u008e\u008f\7-\2\2\u008f\u0091\7\37\2"+
		"\2\u0090\u0092\5\b\5\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u0094\7 \2\2\u0094\u0096\7\35\2\2\u0095\u0097\5\f\7\2\u0096"+
		"\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009e\7\36"+
		"\2\2\u0099\u009a\5\24\13\2\u009a\u009b\5\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009e\7#\2\2\u009dH\3\2\2\2\u009dM\3\2\2\2\u009d\\\3\2\2\2\u009de\3\2"+
		"\2\2\u009dt\3\2\2\2\u009d\177\3\2\2\2\u009d\u0086\3\2\2\2\u009d\u008b"+
		"\3\2\2\2\u009d\u008d\3\2\2\2\u009d\u0099\3\2\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\17\3\2\2\2\u009f\u00a1\7-\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2"+
		"\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00b0\3\2\2\2\u00a4\u00ab"+
		"\7\37\2\2\u00a5\u00a7\7-\2\2\u00a6\u00a8\7\"\2\2\u00a7\u00a6\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa\u00ad\3\2"+
		"\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00b0\7 \2\2\u00af\u00a0\3\2\2\2\u00af\u00a4\3\2"+
		"\2\2\u00b0\21\3\2\2\2\u00b1\u00b8\5\24\13\2\u00b2\u00b4\7\35\2\2\u00b3"+
		"\u00b5\5\f\7\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b8\7\36\2\2\u00b7\u00b1\3\2\2\2\u00b7\u00b2\3\2\2\2\u00b8"+
		"\23\3\2\2\2\u00b9\u00be\5\32\16\2\u00ba\u00bb\7\"\2\2\u00bb\u00bd\5\32"+
		"\16\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\25\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c8\7\61\2"+
		"\2\u00c2\u00c8\7/\2\2\u00c3\u00c4\7\60\2\2\u00c4\u00c5\5\32\16\2\u00c5"+
		"\u00c6\7\36\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c2\3"+
		"\2\2\2\u00c7\u00c3\3\2\2\2\u00c8\27\3\2\2\2\u00c9\u00d1\7\65\2\2\u00ca"+
		"\u00d1\7\66\2\2\u00cb\u00d1\7\63\2\2\u00cc\u00cd\7\64\2\2\u00cd\u00ce"+
		"\5\32\16\2\u00ce\u00cf\7\36\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00c9\3\2\2"+
		"\2\u00d0\u00ca\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d0\u00cc\3\2\2\2\u00d1\31"+
		"\3\2\2\2\u00d2\u00d3\b\16\1\2\u00d3\u00d5\7&\2\2\u00d4\u00d6\7-\2\2\u00d5"+
		"\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\7\37"+
		"\2\2\u00d8\u00da\5\b\5\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\7 \2\2\u00dc\u00de\7\35\2\2\u00dd\u00df\5\f"+
		"\7\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u011b\7\36\2\2\u00e1\u00e2\5\20\t\2\u00e2\u00e3\7$\2\2\u00e3\u00e4\5"+
		"\22\n\2\u00e4\u011b\3\2\2\2\u00e5\u00e6\7-\2\2\u00e6\u011b\7\25\2\2\u00e7"+
		"\u00e8\7\25\2\2\u00e8\u00e9\5\32\16\2\u00e9\u00ea\7\31\2\2\u00ea\u00eb"+
		"\5\24\13\2\u00eb\u00ec\7\32\2\2\u00ec\u011b\3\2\2\2\u00ed\u00ee\7\25\2"+
		"\2\u00ee\u00ef\5\32\16\2\u00ef\u00f0\7\33\2\2\u00f0\u00f1\7-\2\2\u00f1"+
		"\u011b\3\2\2\2\u00f2\u00f3\7\25\2\2\u00f3\u011b\7-\2\2\u00f4\u00f5\7\21"+
		"\2\2\u00f5\u011b\5\32\16\35\u00f6\u00f7\7\17\2\2\u00f7\u011b\5\32\16\34"+
		"\u00f8\u00f9\7-\2\2\u00f9\u00fa\7\34\2\2\u00fa\u011b\5\32\16\27\u00fb"+
		"\u00fc\7-\2\2\u00fc\u00fd\7\24\2\2\u00fd\u011b\5\32\16\16\u00fe\u011b"+
		"\7-\2\2\u00ff\u011b\7\5\2\2\u0100\u011b\7\6\2\2\u0101\u011b\7\7\2\2\u0102"+
		"\u011b\7\b\2\2\u0103\u011b\7\t\2\2\u0104\u011b\5\4\3\2\u0105\u011b\5\6"+
		"\4\2\u0106\u0107\7\37\2\2\u0107\u0108\5\24\13\2\u0108\u0109\7 \2\2\u0109"+
		"\u011b\3\2\2\2\u010a\u010e\7\13\2\2\u010b\u010d\5\26\f\2\u010c\u010b\3"+
		"\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u011b\7.\2\2\u0112\u0116\7\n"+
		"\2\2\u0113\u0115\5\30\r\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0119\u011b\7\62\2\2\u011a\u00d2\3\2\2\2\u011a\u00e1\3\2\2\2\u011a"+
		"\u00e5\3\2\2\2\u011a\u00e7\3\2\2\2\u011a\u00ed\3\2\2\2\u011a\u00f2\3\2"+
		"\2\2\u011a\u00f4\3\2\2\2\u011a\u00f6\3\2\2\2\u011a\u00f8\3\2\2\2\u011a"+
		"\u00fb\3\2\2\2\u011a\u00fe\3\2\2\2\u011a\u00ff\3\2\2\2\u011a\u0100\3\2"+
		"\2\2\u011a\u0101\3\2\2\2\u011a\u0102\3\2\2\2\u011a\u0103\3\2\2\2\u011a"+
		"\u0104\3\2\2\2\u011a\u0105\3\2\2\2\u011a\u0106\3\2\2\2\u011a\u010a\3\2"+
		"\2\2\u011a\u0112\3\2\2\2\u011b\u0171\3\2\2\2\u011c\u011d\f\33\2\2\u011d"+
		"\u011e\7\20\2\2\u011e\u0170\5\32\16\34\u011f\u0120\f\32\2\2\u0120\u0121"+
		"\7\21\2\2\u0121\u0170\5\32\16\33\u0122\u0123\f\31\2\2\u0123\u0124\7\22"+
		"\2\2\u0124\u0170\5\32\16\32\u0125\u0126\f\30\2\2\u0126\u0127\7\23\2\2"+
		"\u0127\u0170\5\32\16\31\u0128\u0129\f\26\2\2\u0129\u012a\7\31\2\2\u012a"+
		"\u012b\5\24\13\2\u012b\u012c\7\32\2\2\u012c\u012d\7\34\2\2\u012d\u012e"+
		"\5\32\16\27\u012e\u0170\3\2\2\2\u012f\u0130\f\25\2\2\u0130\u0131\7\33"+
		"\2\2\u0131\u0132\7-\2\2\u0132\u0133\7\34\2\2\u0133\u0170\5\32\16\26\u0134"+
		"\u0135\f\24\2\2\u0135\u0136\7\34\2\2\u0136\u0170\5\32\16\25\u0137\u0138"+
		"\f\23\2\2\u0138\u0139\7\26\2\2\u0139\u0170\5\32\16\24\u013a\u013b\f\22"+
		"\2\2\u013b\u013c\7\27\2\2\u013c\u0170\5\32\16\23\u013d\u013e\f\21\2\2"+
		"\u013e\u013f\7\30\2\2\u013f\u0140\5\32\16\2\u0140\u0141\7!\2\2\u0141\u0142"+
		"\5\32\16\22\u0142\u0170\3\2\2\2\u0143\u0144\f\20\2\2\u0144\u0145\7\31"+
		"\2\2\u0145\u0146\5\24\13\2\u0146\u0147\7\32\2\2\u0147\u0148\7\24\2\2\u0148"+
		"\u0149\5\32\16\21\u0149\u0170\3\2\2\2\u014a\u014b\f\17\2\2\u014b\u014c"+
		"\7\33\2\2\u014c\u014d\7-\2\2\u014d\u014e\7\24\2\2\u014e\u0170\5\32\16"+
		"\20\u014f\u0150\f\'\2\2\u0150\u0151\7\31\2\2\u0151\u0152\5\24\13\2\u0152"+
		"\u0153\7\32\2\2\u0153\u0170\3\2\2\2\u0154\u0155\f&\2\2\u0155\u0156\7\33"+
		"\2\2\u0156\u0157\7-\2\2\u0157\u0159\7\37\2\2\u0158\u015a\5\24\13\2\u0159"+
		"\u0158\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0170\7 "+
		"\2\2\u015c\u015d\f%\2\2\u015d\u015e\7\33\2\2\u015e\u0170\7-\2\2\u015f"+
		"\u0160\f$\2\2\u0160\u0162\7\37\2\2\u0161\u0163\5\24\13\2\u0162\u0161\3"+
		"\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0170\7 \2\2\u0165"+
		"\u0166\f#\2\2\u0166\u0167\7\31\2\2\u0167\u0168\5\24\13\2\u0168\u0169\7"+
		"\32\2\2\u0169\u016a\7\25\2\2\u016a\u0170\3\2\2\2\u016b\u016c\f\"\2\2\u016c"+
		"\u016d\7\33\2\2\u016d\u016e\7-\2\2\u016e\u0170\7\25\2\2\u016f\u011c\3"+
		"\2\2\2\u016f\u011f\3\2\2\2\u016f\u0122\3\2\2\2\u016f\u0125\3\2\2\2\u016f"+
		"\u0128\3\2\2\2\u016f\u012f\3\2\2\2\u016f\u0134\3\2\2\2\u016f\u0137\3\2"+
		"\2\2\u016f\u013a\3\2\2\2\u016f\u013d\3\2\2\2\u016f\u0143\3\2\2\2\u016f"+
		"\u014a\3\2\2\2\u016f\u014f\3\2\2\2\u016f\u0154\3\2\2\2\u016f\u015c\3\2"+
		"\2\2\u016f\u015f\3\2\2\2\u016f\u0165\3\2\2\2\u016f\u016b\3\2\2\2\u0170"+
		"\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\33\3\2\2"+
		"\2\u0173\u0171\3\2\2\2& .\62;?FJWchw\u0081\u0084\u0088\u0091\u0096\u009d"+
		"\u00a2\u00a7\u00ab\u00af\u00b4\u00b7\u00be\u00c7\u00d0\u00d5\u00d9\u00de"+
		"\u010e\u0116\u011a\u0159\u0162\u016f\u0171";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}