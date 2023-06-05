// Generated from /Users/charles/Documents/projects/Espresso/src/main/resources/Espresso.g4 by ANTLR 4.12.0

package espresso;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EspressoParser}.
 */
public interface EspressoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EspressoParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(EspressoParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(EspressoParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(EspressoParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(EspressoParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(EspressoParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(EspressoParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(EspressoParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(EspressoParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(EspressoParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(EspressoParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(EspressoParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(EspressoParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(EspressoParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(EspressoParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#typeTypeOrVoid}.
	 * @param ctx the parse tree
	 */
	void enterTypeTypeOrVoid(EspressoParser.TypeTypeOrVoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#typeTypeOrVoid}.
	 * @param ctx the parse tree
	 */
	void exitTypeTypeOrVoid(EspressoParser.TypeTypeOrVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameList(EspressoParser.QualifiedNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameList(EspressoParser.QualifiedNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(EspressoParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(EspressoParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(EspressoParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(EspressoParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(EspressoParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(EspressoParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(EspressoParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(EspressoParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(EspressoParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(EspressoParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(EspressoParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(EspressoParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(EspressoParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(EspressoParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(EspressoParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(EspressoParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(EspressoParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(EspressoParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(EspressoParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(EspressoParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(EspressoParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(EspressoParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(EspressoParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(EspressoParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(EspressoParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(EspressoParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(EspressoParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(EspressoParser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(EspressoParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(EspressoParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(EspressoParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(EspressoParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(EspressoParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(EspressoParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(EspressoParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(EspressoParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(EspressoParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(EspressoParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(EspressoParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(EspressoParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(EspressoParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(EspressoParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(EspressoParser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(EspressoParser.EnhancedForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(EspressoParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(EspressoParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(EspressoParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(EspressoParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(EspressoParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(EspressoParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(EspressoParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(EspressoParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(EspressoParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(EspressoParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(EspressoParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(EspressoParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#typeType}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(EspressoParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#typeType}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(EspressoParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(EspressoParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(EspressoParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EspressoParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(EspressoParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EspressoParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(EspressoParser.PrimitiveTypeContext ctx);
}