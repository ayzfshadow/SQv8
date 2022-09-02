package saki.ui.packagec;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

public class mark24_classa extends PasswordTransformationMethod {
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new mark24_classb(this, charSequence);
    }
}
