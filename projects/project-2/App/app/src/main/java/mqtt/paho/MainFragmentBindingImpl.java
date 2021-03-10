package mqtt.paho;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public class MainFragmentBindingImpl extends ViewDataBinding {

  /**
   * Needed for backwards binary compatibility. b/122936785
   *
   * @param bindingComponent
   * @param root
   * @param localFieldCount
   * @hide
   */
  protected MainFragmentBindingImpl(DataBindingComponent bindingComponent,
      View root, int localFieldCount) {
    super(bindingComponent, root, localFieldCount);
  }

  /**
   * Called when an observed object changes. Sets the appropriate dirty flag if applicable.
   *
   * @param localFieldId The index into mLocalFieldObservers that this Object resides in.
   * @param object       The object that has changed.
   * @param fieldId      The BR ID of the field being changed or _all if no specific field is being
   *                     notified.
   * @return true if this change should cause a change to the UI.
   * @hide
   */
  @Override
  protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
    return false;
  }

  /**
   * Set a value value in the Binding class.
   * <p>
   * Typically, the developer will be able to call the subclass's set method directly. For example,
   * if there is a variable <code>x</code> in the Binding, a <code>setX</code> method will be
   * generated. However, there are times when the specific subclass of ViewDataBinding is unknown,
   * so the generated method cannot be discovered without reflection. The setVariable call allows
   * the values of variables to be set without reflection.
   *
   * @param variableId the BR id of the variable to be set. For example, if the variable is
   *                   <code>x</code>, then variableId will be <code>BR.x</code>.
   * @param value      The new value of the variable to be set.
   * @return <code>true</code> if the variable is declared or used in the binding or
   * <code>false</code> otherwise.
   */
  @Override
  public boolean setVariable(int variableId, @Nullable Object value) {
    return false;
  }

  /**
   * @hide
   */
  @Override
  protected void executeBindings() {

  }

  /**
   * Invalidates all binding expressions and requests a new rebind to refresh UI.
   */
  @Override
  public void invalidateAll() {

  }

  /**
   * Returns whether the UI needs to be refresh to represent the current data.
   *
   * @return true if any field has changed and the binding should be evaluated.
   */
  @Override
  public boolean hasPendingBindings() {
    return false;
  }
}
