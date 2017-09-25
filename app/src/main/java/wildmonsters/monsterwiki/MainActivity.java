package wildmonsters.monsterwiki;


import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<listeMonstre> arrayofliste;

    listeMonstreAdapter adapter;
    ListView lv;
    String monsterID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Customize the ActionBar
        final ActionBar abar = getSupportActionBar();

        View viewActionBar = getLayoutInflater().inflate(R.layout.action_bar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView titleActionBar = (TextView) viewActionBar.findViewById(R.id.action_bar_title);
        titleActionBar.setText("MONSTERS LIST");
        Typeface police = Typeface.createFromAsset(getAssets(),"fonts/Curse_Casual.ttf");
        titleActionBar.setTypeface(police);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(false);
        abar.setHomeButtonEnabled(false);

        //Appel de la CustomList (ListeMonstreAdapter) et de la listview du XML (Activity_main)
        arrayofliste = new ArrayList<listeMonstre>();
        adapter = new listeMonstreAdapter(this, arrayofliste);
        lv = (ListView) findViewById(R.id.list_monster);
        lv.setAdapter(adapter);

        //Définition de nos monstres selon l'objet listeMonstre
        listeMonstre monstre1 = new listeMonstre("Fire Lion", "Fire", R.drawable.fire_lion_1, R.drawable.fire);
        listeMonstre monstre2 = new listeMonstre("Arch Knight", "Legend", R.drawable.arch_knight_1, R.drawable.legend);
        listeMonstre monstre3 = new listeMonstre("Genie", "Magic", R.drawable.genie_1, R.drawable.magic);
        listeMonstre monstre4 = new listeMonstre("Light Spirit", "Light", R.drawable.light_spirit_1, R.drawable.light);
        listeMonstre monstre5 = new listeMonstre("Metalsaur", "Metal", R.drawable.metalsaur_1, R.drawable.metal);
        listeMonstre monstre6 = new listeMonstre("Panda", "Nature", R.drawable.panda_1, R.drawable.nature);
        listeMonstre monstre7 = new listeMonstre("Rockilla", "Earth", R.drawable.rockilla_1, R.drawable.earth);
        listeMonstre monstre8 = new listeMonstre("Thunder Eagle", "Thunder", R.drawable.thunder_eagle_1,R.drawable.thunder);
        listeMonstre monstre9 = new listeMonstre("Tyrannoking", "Dark", R.drawable.tyrannoking_1, R.drawable.dark);
        listeMonstre monstre10 = new listeMonstre("Turtle", "Water", R.drawable.turtle_1, R.drawable.water);

        //Utilisation de la CustomList (Ajout des monstres dans la listview)
        adapter.add(monstre1);
        adapter.add(monstre2);
        adapter.add(monstre3);
        adapter.add(monstre4);
        adapter.add(monstre5);
        adapter.add(monstre6);
        adapter.add(monstre7);
        adapter.add(monstre8);
        adapter.add(monstre9);
        adapter.add(monstre10);

        //Lors du clic sur une ligne de la liste, récuperer la position i et l'envoyer à DetailsActivity via intent
        lv.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {
                listeMonstre item = (listeMonstre) adapter.getItemAtPosition(i);

                Intent intent = new Intent(MainActivity.this,details_Activity.class);
                intent.putExtra("monsterID", i);
                startActivity(intent);
            }

        });

    }


}