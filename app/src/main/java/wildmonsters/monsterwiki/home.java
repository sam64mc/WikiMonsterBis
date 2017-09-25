package wildmonsters.monsterwiki;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class home extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Bouton (ajout d'une custom font)
        Button home = (Button) findViewById(R.id.buttonHome);
        Typeface police5 = Typeface.createFromAsset(getAssets(),"fonts/Curse_Casual.ttf");
        home.setTypeface(police5);

        //Customize the ActionBar (centrer, texte personnalisé, custom font)
        final ActionBar abar = getSupportActionBar();

        View viewActionBar = getLayoutInflater().inflate(R.layout.action_bar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView titleActionBar = (TextView) viewActionBar.findViewById(R.id.action_bar_title);
        titleActionBar.setText("MONSTER LEGENDS WIKI");
        Typeface police = Typeface.createFromAsset(getAssets(),"fonts/Curse_Casual.ttf");
        titleActionBar.setTypeface(police);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(false);
        abar.setHomeButtonEnabled(false);

        //Image arriere plan
        ImageButton homebutton = (ImageButton) findViewById(R.id.homeButton);

        //Lors du clic sur le bouton, aller à MainActivity
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
            }

});
        //Lors du clic sur l'image background, aller à MainActivity
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}
