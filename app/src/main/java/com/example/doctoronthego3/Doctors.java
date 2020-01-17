package com.example.doctoronthego3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Doctors extends AppCompatActivity {

    ListView mylistview;
    int[] img =new int[]{R.mipmap.ic_diag_mdoc,
                R.mipmap.ic_diag_mdoc,
                R.mipmap.ic_diag_fdoc,
                R.mipmap.ic_diag_mdoc,
                R.mipmap.ic_diag_fdoc};

    String[] Names=new String[]{"Dr. Muhammad Shahzad Shamim\n" +
            "Neuro Surgeon\n"+
            "MBBS, FCPS, FRCS (UK)\n" +
            "expertise include\n"+
            "Brain & Spine Tumors, Function Neurosurgery:essential Tremors,Parkinson Disease,Depress Fractures, head injury",
            "Dr. Ajmal Rashid\n" +
                    "Dermatologist\n" +
                    "MBBS, D Derm, MCPS, FCPS\n" +
                    "Consultant & Specialized In Clinical Dermatology",
            "Dr. Sarochana Khemani\n" +
                    "Gynecologist\n" +
                    "MBBS, FCPS (Gynecology), MRCOG\n" +
                    "expertise include Gynecology, Obstetrician, High-risk surgery Obs & Gyne",
            "Dr. Syed Arsalan Ali\n" +
                    "General Physician\n" +
                    "MBBS\n" +
                    "His area of expertise include Gastroenterology, Hepatolgy , Infectious Diseases, blood pressure, heart diseases",
            "Dr. Madiha Zia\n" +
                    "General Physician\n" +
                    "MBBS, FCPS\n" +
                    "Consultant & Specialized In:\n" +
                    "Hepatolgy , Infectious Diseases, heart diseases, Hypertension, Diabetes, Thyroid, Hormonal Issues, Chronic Liver diseases"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        mylistview= findViewById(R.id.list);
        CustomAdaptor customAdaptor= new CustomAdaptor();
        mylistview.setAdapter(customAdaptor);
    }
    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView mImageView = view.findViewById(R.id.limageView);
            TextView  mtextview = view.findViewById(R.id.ltext3);

            mImageView.setImageResource(img[position]);
            mtextview.setText((Names[position]));

            return view;
        }
    }
}
