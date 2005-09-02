package com.intellij.psi.impl.light;

import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;

/**
 *  @author dsl
 */
public abstract class ImplicitVariableImpl extends LightVariableBase implements ImplicitVariable {

  public ImplicitVariableImpl(PsiManager manager, PsiIdentifier nameIdentifier, PsiType type, boolean writable, PsiElement scope) {
    super(manager, nameIdentifier, type, writable, scope);
  }

  public void accept(PsiElementVisitor visitor) {
    visitor.visitImplicitVariable(this);
  }

  public String toString() {
    return "Implicit variable:" + getName();
  }

  public void setInitializer(PsiExpression initializer) throws IncorrectOperationException {
    throw new IncorrectOperationException();
  }
}
