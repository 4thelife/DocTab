package com.example.antonio.doctab;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.google.firebase.auth.FirebaseAuth;

public class ActivityAccount extends AppCompatActivity {

    Button nuevodia;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        nuevodia = (Button)findViewById(R.id.btn_nvoDia);
        nuevodia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityAccount.this,Activity_agregar_horario.class);
                startActivity(intent);
            }
        });
    }


}
