package wildmonsters.monsterwiki;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//Création d'une CustomView pour notre ListView selon l'objet Monstre (class ListeMonstre)

public class listeMonstreAdapter extends ArrayAdapter<listeMonstre> {

    public listeMonstreAdapter(Context context, ArrayList<listeMonstre> liste){
        super(context, 0, liste);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        listeMonstre listeM = getItem(position);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listemonstre_item,parent, false);
        }

        //Définition variables + find ID
        TextView nomMonstre = (TextView)convertView.findViewById(R.id.nomMonstre);
        TextView nomElement = (TextView)convertView.findViewById(R.id.nomElement);
        ImageView imageMonstre = (ImageView)convertView.findViewById(R.id.imageMonstre);
        ImageView imageElement = (ImageView)convertView.findViewById(R.id.imageElement);

        nomMonstre.setText(listeM.nomMonstre);
        nomElement.setText(listeM.nomElement);
        imageMonstre.setImageResource(listeM.imageMonstre);
        imageElement.setImageResource(listeM.imageElement);

        //Ajout d'une custom font au nom du monstre de l'élément
        Typeface police1 = Typeface.createFromAsset(getContext().getAssets(),"fonts/UnZialish.ttf");
        nomMonstre.setTypeface(police1);
        Typeface police2 = Typeface.createFromAsset(getContext().getAssets(),"fonts/Curse_Casual.ttf");
        nomElement.setTypeface(police2);

        return convertView;
    }


}