package app.vini.com.meadota.Fragments.Cadastro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import app.vini.com.meadota.R;
import app.vini.com.meadota.Util.SignupFragment;


public class UserRegistrationFragment extends SignupFragment implements View.OnClickListener {

    private Button nextStep;
    private TextInputLayout mContactEmail, mTelephoneNumber, mMobileNumber, mOfficeNumber;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup contantGroup = (ViewGroup) inflater.inflate(R.layout.fragment_cadastro1, container, false);
        //nextStep = (Button) contantGroup.findViewById(R.id.btNextStep);
        //nextStep.setOnClickListener(this);
        return contantGroup;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mContactEmail = (TextInputLayout) view.findViewById(R.id.tilContactEmail);
//        mTelephoneNumber = (TextInputLayout) view.findViewById(R.id.tilPhoneNumber);
//        mMobileNumber = (TextInputLayout) view.findViewById(R.id.tilMobileNumber);
//        mOfficeNumber = (TextInputLayout) view.findViewById(R.id.tilOfficeNumber);
    }

    @Override
    public void onClick(View view) {

        String contactEmail = mContactEmail.getEditText().getText().toString();
        String telephoneNumber = mTelephoneNumber.getEditText().getText().toString();
        String mobileNumber = mMobileNumber.getEditText().getText().toString();
        String officeNumber = mOfficeNumber.getEditText().getText().toString();

        //EventBus.getDefault().post(new UserDataEvent(telephoneNumber, mobileNumber, officeNumber, contactEmail));

        getViewPager().setCurrentItem(2);
    }
}