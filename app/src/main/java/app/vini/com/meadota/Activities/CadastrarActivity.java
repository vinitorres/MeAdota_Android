package app.vini.com.meadota.Activities;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;
import com.google.firebase.auth.FirebaseAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import app.vini.com.meadota.Helper.NonSwipeableViewPager;
import app.vini.com.meadota.Model.User;
import app.vini.com.meadota.R;
import app.vini.com.meadota.Util.SignupFragment;
import butterknife.ButterKnife;

public class CadastrarActivity extends AppCompatActivity {

    private PagerAdapter mPagerAdapter;
    private ProgressDialog mProgressBar;
    HorizontalStepView  mHorizontalStep;
    private User user;
    private NonSwipeableViewPager vpSignupSlider;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_cadastrar);
        List<Fragment> signupStepFragments = new ArrayList();
//        signupStepFragments.add(new DoctorPersonalDataSignupFragment());
//        signupStepFragments.add(new DoctorContactDataSignpFragment());
//        signupStepFragments.add(new DoctorOfficeDataSignpFragment());
//        vpSignupSlider = (NonSwipeableViewPager) findViewById(R.id.vpSignupSlider);
//        mPagerAdapter = new SignupStepSlideAdapter(getSupportFragmentManager(), signupStepFragments);
        vpSignupSlider.setAdapter(mPagerAdapter);
        //setWizardStepProgressBar();

    }

//    @OnClick(R.id.btnCadastrar)
//    public void cadastrar() {
//        if (!etNome.getText().toString().equals("") ||
//                !etSobrenome.getText().toString().equals("") ||
//                !etNome.getText().toString().equals("") ||
//                !etNome.getText().toString().equals("")) {
//
//            final String nome = etNome.getText().toString();
//            final String sobrenome = etNome.getText().toString();
//            String email = etNome.getText().toString();
//            String senha = etNome.getText().toString();
//
//            mAuth.createUserWithEmailAndPassword(email, senha)
//                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            Log.d("Novo usuario :", "createUserWithEmail:onComplete:" + task.isSuccessful());
//
//                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//
//                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                                    .setDisplayName(nome + " " + sobrenome).build();
//                            user.updateProfile(profileUpdates);
//
//                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                            startActivity(intent);
//
//                            if (!task.isSuccessful()) {
//
//                            }
//
//                      }
//                    });
//
//        }
//
//    }

//    private class SignupStepSlideAdapter extends FragmentStatePagerAdapter {
//
//        private List<Fragment> fragments;
//
//        public SignupStepSlideAdapter(FragmentManager fm, List<Fragment> fragments) {
//            super(fm);
//            this.fragments = fragments;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            SignupFragment fragment = (SignupFragment) fragments.get(position);
//            fragment.setViewPager(vpSignupSlider);
//            return fragment;
//        }
//
//        @Override
//        public int getCount() {
//            return fragments.size();
//        }
//    }
//
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    protected void onStop() {
//        EventBus.getDefault().unregister(this);
//        super.onStop();
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (vpSignupSlider.getCurrentItem() == 0) {
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            vpSignupSlider.setCurrentItem(vpSignupSlider.getCurrentItem() - 1);
//        }
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onUserMessageEvent(UserDataEvent event) {
//        user = new User();
//        user.setName(event.name);
//        user.setEmail(event.email);
//        user.setCpf(event.cpf);
//        user.setPassword(event.password);
//        List<StepBean> stepsBeanList = new ArrayList<>();
//        StepBean stepBeanPersonal = new StepBean("Personal",1);
//        StepBean stepBeanContact = new StepBean("Contact",-1);
//        StepBean stepBeanAddress = new StepBean("Address",-1);
//        stepsBeanList.add(stepBeanPersonal);
//        stepsBeanList.add(stepBeanContact);
//        stepsBeanList.add(stepBeanAddress);
//        mHorizontalStep.setStepViewTexts(stepsBeanList);
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onUserContactMessageEvent(DoctorContactDataEvent event) {
//        user.setContactEmail(event.contactEmail);
//        user.setTelephoneNumber(event.telephoneNumber);
//        user.setMobileNumber(event.mobileNumber);
//        user.setOfficeNumber(event.officeNumber);
//
//        List<StepBean> stepsBeanList = new ArrayList<>();
//        StepBean stepBeanPersonal = new StepBean("Personal",1);
//        StepBean stepBeanContact = new StepBean("Contact",1);
//        StepBean stepBeanAddress = new StepBean("Address",-1);
//        stepsBeanList.add(stepBeanPersonal);
//        stepsBeanList.add(stepBeanContact);
//        stepsBeanList.add(stepBeanAddress);
//        mHorizontalStep.setStepViewTexts(stepsBeanList);
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onDoctorOfficeMessageEvent(UserDataEvent event) {
//        user.setStreet(event.street);
//
//        List<StepBean> stepsBeanList = new ArrayList<>();
//        StepBean stepBeanPersonal = new StepBean("Personal",1);
//        StepBean stepBeanContact = new StepBean("Contact",1);
//        StepBean stepBeanAddress = new StepBean("Address",1);
//        stepsBeanList.add(stepBeanPersonal);
//        stepsBeanList.add(stepBeanContact);
//        stepsBeanList.add(stepBeanAddress);
//        mHorizontalStep.setStepViewTexts(stepsBeanList);
//
//        mProgressBar = new ProgressDialog(this);
//        mProgressBar.setMessage(getString(R.string.sending_data));
//        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        mProgressBar.setCancelable(true);
//        mProgressBar.show();
//
//        DoctorRetorfitClient.getClient().signup(user).enqueue(new Callback<GenericResponse>() {
//            @Override
//            public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
//                mProgressBar.hide();
//                //startActivity(new Intent(DoctorSignupActivity.this,LoginActivity.class));
//            }
//
//            @Override
//            public void onFailure(Call<GenericResponse> call, Throwable t) {
//                mProgressBar.hide();
//            }
//        });
//
//    }
//
//    public void setWizardStepProgressBar(){
//        mHorizontalStep = (HorizontalStepView) findViewById(R.id.step_view);
//        List<StepBean> stepsBeanList = new ArrayList<>();
//        StepBean stepBeanPersonal = new StepBean("Personal",-1);
//        StepBean stepBeanContact = new StepBean("Contact",-1);
//        StepBean stepBeanAddress = new StepBean("Address",-1);
//        stepsBeanList.add(stepBeanPersonal);
//        stepsBeanList.add(stepBeanContact);
//        stepsBeanList.add(stepBeanAddress);
//        mHorizontalStep
//                .setStepViewTexts(stepsBeanList)
//                .setTextSize(12)
//                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, R.color.colorTextAndIcons))
//                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.colorTextAndIcons))
//                .setStepViewComplectedTextColor(ContextCompat.getColor(this, R.color.colorTextAndIcons))
//                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.colorTextAndIcons));
//    }
}
