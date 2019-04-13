package otes06.br.example.udesc.roomteste;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends Activity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista = findViewById(R.id.lista);
        new PopulateTask().execute();
    }

    class PopulateTask extends AsyncTask<User, Integer, List<User>> {

        @Override
        protected List<User> doInBackground(User... users) {

            AppDatabase db = Repository.getInstance(getApplicationContext());

            return db.userDao().loadAll();
        }

        @Override
        protected void onPostExecute( List<User> users) {

            lista.setAdapter(new ArrayAdapter(
                    ListActivity.this, android.R.layout.simple_expandable_list_item_1, users
            ));

        }
    }

}
