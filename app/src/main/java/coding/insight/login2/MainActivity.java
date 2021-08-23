package coding.insight.login2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView username =(TextView) findViewById(R.id.username_input);
        final TextView password =(TextView) findViewById(R.id.pass);

        String passInp = password.getText().toString().trim();
        final String emailPatt = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        final String stringRegEx = "((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";

        TextView loginbtn = (TextView) findViewById(R.id.loginBtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty()){
                    username.setError("This can't be Empty");
                    username.findFocus();
                }
                else if (!username.getText().toString().trim().matches(emailPatt)) {
                    username.setError("Enter email in Correct format.");
                }
                else if(password.getText().toString().isEmpty()){
                    password.setError("Password can't be empty ");
                }
                else if (!password.getText().toString().trim().matches(stringRegEx)) {
                    password.setError("Please enter strong Password.");
                }
                else if(username.getText().toString().equals("Shahbaaz@gmail.com") && password.getText().toString().equals("Shahbaaz@1")){
                    //correct
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                }else
                    //incorrect
                    Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
