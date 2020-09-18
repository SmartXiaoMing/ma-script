/* antlr4 SkilSquareOpencript.g4 -no-listener -package com.xiaoming.script.api.utiSquareOpen.script */
parser grammar MaScriptParser;

options { tokenVocab=MaScriptLexer; }

sep
    : Semicolon
    | EOF
    ;


array
    : SquareOpen exprs? SquareClose
    ;

object
    : BlockOpen Id Colon singleExpr (Comma Id Colon singleExpr)* Comma? BlockClose
    ;

ids
    : Id (Comma Id)*
    ;

program
    : stats? EOF
    ;

stats
    : stat+
    ;

stat
    : BlockOpen stats? BlockClose                                                                       # BlockStat
    | Var Id Assign singleExpr (Comma Id Assign singleExpr)* Semicolon                                  # VarStat
    | If ParenOpen exprs ParenClose stat (Else stat)?                                                   # IfStat
    | For ParenOpen Var? Id Assign singleExpr Semicolon singleExpr Semicolon singleExpr ParenClose stat # ForItStat
    | For ParenOpen Var? Id Colon singleExpr ParenClose stat                                            # ForInStat
    | Return exprs? sep?                                                                                # ReturnStat
    | Break exprs? Semicolon                                                                            # BreakStat
    | Continue Semicolon                                                                                # ContinuekStat
    | Function Id ParenOpen ids? ParenClose BlockOpen stats? BlockClose                                 # FuncDefStat
    | exprs sep                                                                                         # exprsStat
    | Semicolon                                                                                         # EmptyStat
    ;

lambdaParam
    : Id+
    | ParenOpen (Id Comma?)* ParenClose
    ;

lambdaBody
    : exprs
    | BlockOpen stats? BlockClose
    ;

exprs
    : singleExpr (Comma singleExpr)*
    ;

stringFormatPart
    : TextFormat
    | IdInterp
    | ExprInterpOpen singleExpr BlockClose
    ;

backStringFormatPart
    : BackStringFormatSquare
    | BackTextFormat
    | BackIdInterp
    | BackExprInterpOpen singleExpr BlockClose
    ;

singleExpr
    : Function Id? ParenOpen ids? ParenClose BlockOpen stats? BlockClose # FuncDefExpr
    | lambdaParam Arrow lambdaBody                                       # LambdaDefExpr
    | singleExpr SquareOpen exprs SquareClose                            # MemberIndexExpr
    | singleExpr Dot Id ParenOpen exprs? ParenClose                      # MemberFuncCallExpr
    | singleExpr Dot Id                                                  # MemberDotExpr
    | singleExpr ParenOpen exprs? ParenClose                             # FuncCallExpr
    | singleExpr SquareOpen exprs SquareClose Inc                        # MemberIndexIncExpr
    | singleExpr Dot Id Inc                                              # MemberDotIncExpr
    | Id Inc                                                             # IdIncExpr
    | Inc singleExpr SquareOpen exprs SquareClose                        # IncMemberIndexExpr
    | Inc singleExpr Dot Id                                              # IncMemberDotExpr
    | Inc Id                                                             # IncIdExpr
    | Add singleExpr                                                     # UnaryMinusExpr
    | Not singleExpr                                                     # NotExpr
    | singleExpr Mult singleExpr                                         # MultExpr
    | singleExpr Add singleExpr                                          # AddExpr
    | singleExpr Relation singleExpr                                     # RelationExpr
    | singleExpr Eq singleExpr                                           # EqExpr
    | Id Assign singleExpr                                               # IdAssignExpr
    | singleExpr SquareOpen exprs SquareClose Assign singleExpr          # MemberIndexAssignExpr
    | singleExpr Dot Id Assign singleExpr                                # MemberDotAssignExpr
    | singleExpr Assign singleExpr                                       # ExprAssignExpr
    | singleExpr And singleExpr                                          # AndExpr
    | singleExpr Or singleExpr                                           # OrExpr
    | singleExpr Query singleExpr Colon singleExpr                       # TernaryExpr
    | singleExpr SquareOpen exprs SquareClose AssignAppend singleExpr    # MemberIndexAssignAppendExpr
    | singleExpr Dot Id AssignAppend singleExpr                          # MemberDotAssignAppendExpr
    | Id AssignAppend singleExpr                                         # IdAssignAppendExpr
    | Id                                                                 # IdExpr
    | Null                                                               # NullExpr
    | Bool                                                               # BoolExpr
    | Int                                                                # IntExpr
    | Float                                                              # FloatExpr
    | String                                                             # StringExpr
    | array                                                              # ArrayExpr
    | object                                                             # ObjectExpr
    | ParenOpen exprs ParenClose                                         # PriorityExpr
    | StringFormatOpen stringFormatPart* StringFormatClose               # stringFormatExpr
    | BackStringFormatOpen backStringFormatPart* BackStringFormatClose   # triStringFormatExpr
    ;

