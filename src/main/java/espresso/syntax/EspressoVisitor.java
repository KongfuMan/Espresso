// Generated from /Users/charles/Documents/projects/Espresso/src/main/resources/Espresso.g4 by ANTLR 4.12.0

package espresso.syntax;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EspressoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EspressoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EspressoParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(EspressoParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(EspressoParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(EspressoParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(EspressoParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration(EspressoParser.MemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(EspressoParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(EspressoParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#typeTypeOrVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeTypeOrVoid(EspressoParser.TypeTypeOrVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedNameList(EspressoParser.QualifiedNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(EspressoParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(EspressoParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(EspressoParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(EspressoParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(EspressoParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(EspressoParser.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(EspressoParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(EspressoParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(EspressoParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(EspressoParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(EspressoParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(EspressoParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(EspressoParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#floatLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(EspressoParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(EspressoParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(EspressoParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(EspressoParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(EspressoParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(EspressoParser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(EspressoParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(EspressoParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#enhancedForControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForControl(EspressoParser.EnhancedForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(EspressoParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(EspressoParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(EspressoParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(EspressoParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(EspressoParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(EspressoParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#typeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(EspressoParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(EspressoParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EspressoParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(EspressoParser.PrimitiveTypeContext ctx);
}