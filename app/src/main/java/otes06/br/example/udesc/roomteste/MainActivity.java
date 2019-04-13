package otes06.br.example.udesc.roomteste;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText senha;
    Integer idAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.idNome);
        senha = findViewById(R.id.idSenha);
        Button confirmar = findViewById(R.id.idBotao);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random gerador = new Random();
                idAleatorio = gerador.nextInt(1000000);
                Toast.makeText(MainActivity.this, idAleatorio+"", Toast.LENGTH_SHORT).show();

                User userFull = new User(idAleatorio, usuario.getText().toString(), senha.getText().toString());

                new PopulateTask().execute(userFull);

            }
        });

        Button BotaoLista = findViewById(R.id.idBotaoLista);

        BotaoLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });

    }

    class PopulateTask extends AsyncTask<User, Integer, List<User>>{

        @Override
        protected List<User> doInBackground(User... users) {

            AppDatabase db = Repository.getInstance(getApplicationContext());

            User U = users[0];
            db.userDao().save(U);
            return db.userDao().loadAll();
        }

        @Override
        protected void onPostExecute( List<User> users) {
            System.out.println("###########");

            for (User U:users){
                //System.out.println(U.getId());
                System.out.println(U.getName());
                //System.out.println(U.getPass());
            }

        }
    }

//    class DeleteTask extends AsyncTask<Void, Integer, Void>{
//
//        @Override
//        protected Void doInBackground(Void... users) {
//
//            AppDatabase db = Repository.getInstance(getApplicationContext());
//
//                db.userDao().removeAll();
//
//                return null;
//        }
//
//        @Override
//        protected void onPostExecute( Void users) {
//            System.out.println("Deletou");
//
//        }
//    }

}
