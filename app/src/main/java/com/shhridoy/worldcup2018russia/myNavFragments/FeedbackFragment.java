package com.shhridoy.worldcup2018russia.myNavFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shhridoy.worldcup2018russia.R;

/**
 * Created by Dream Land on 3/10/2018.
 */

public class FeedbackFragment extends Fragment {

    EditText etSubject, etMessage;
    Button btnSend;
    static final String MAIL_ADDRESS = "md.saifulhq@gmail.com";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.feedback_fragment, container, false);

        initializeViews(rootView);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etMessage.getText().toString().length() <= 0) {
                    Toast.makeText(getContext(), "You shouldn't keep message field empty!!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{MAIL_ADDRESS});
                    email.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString().isEmpty() ? null : etSubject.getText().toString());
                    email.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());
                    email.setType("message/rfc822");
                    getContext().startActivity(Intent.createChooser(email, "Choose app to send feedback"));
                }
            }
        });


        return rootView;
    }

    private void initializeViews(View v) {
        etSubject = v.findViewById(R.id.ETSubject);
        etMessage = v.findViewById(R.id.ETMessage);
        btnSend = v.findViewById(R.id.SendButton);
    }

}
