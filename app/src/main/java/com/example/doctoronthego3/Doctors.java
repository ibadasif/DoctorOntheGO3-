package com.example.doctoronthego3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
                R.mipmap.ic_diag_fdoc,
                R.mipmap.ic_diag_fdoc,
                R.mipmap.ic_diag_mdoc,
                R.mipmap.ic_diag_fdoc,
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
                    "Hepatolgy , Infectious Diseases, heart diseases, Hypertension, Diabetes, Thyroid, Hormonal Issues, Chronic Liver diseases",
            "Prof. Attiya Sabeen Rahman\n" +
                    "MD(Neurology), F.C.P.S. (Medicine), MRCP (UK)\n" +
                    "Internal Medicine Specialist, Neurologist",
            "Dr. Akhtar Memon\n" +
                    "MBBS, MCPS, MRCGP (UK), MOH (UAE)\n" +
                    "Internal Medicine Specialist, General Physician, Family Physician",
            "Dr. Shehla Amir\n" +
                    "M.B.B.S, APCA (Canada), ARDMS (Canada)\n" +
                    "Family Physician",
            "Dr. Sumera Memon\n" +
                    "M.B.B.S., Dip. Dermatology , Diplomate in Aesthetic Medicine AAAM (USA), Certified Laser Specialist NCLC ( USA), MBA -Health Management (Distinction)\n" +
                    "Dermatologist, Laser Specialist, Cosmetologist",
            "Dr. Sohail Tirmizi\n" +
                    "M.B.B.S., D.L.O, F.C.P.S.\n" +
                    "ENT Specialist, ENT Surgeon",
            "Dr. Jasmeen Sajid\n" +
                    "MBA, DHMS, Hijama Specialist\n" +
                    "Acupuncturist, Homeopath"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        mylistview= findViewById(R.id.list);
        CustomAdaptor customAdaptor= new CustomAdaptor();
        mylistview.setAdapter(customAdaptor);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent a = new Intent(Doctors.this,Aku.class);
                    startActivity(a);
                }
                if (position==1){
                    Intent b = new Intent(Doctors.this,Aku.class);
                    startActivity(b);
                }
                if (position==2){
                    Intent c = new Intent(Doctors.this,Heah.class);
                    startActivity(c);
                }
                if (position==3){
                    Intent d = new Intent(Doctors.this,Dow.class);
                    startActivity(d);
                }
                if (position==4){
                    Intent e = new Intent(Doctors.this,Dow.class);
                    startActivity(e);
                }
                if (position==5){
                    Intent f = new Intent(Doctors.this,Camps.class);
                    startActivity(f);
                }
                if (position==6){
                    Intent g = new Intent(Doctors.this,Taj.class);
                    startActivity(g);
                }
                if (position==7){
                    Intent h = new Intent(Doctors.this,Kmc.class);
                    startActivity(h);
                }
                if (position==8){
                    Intent i = new Intent(Doctors.this,Dsm.class);
                    startActivity(i);
                }
                if (position==9){
                    Intent j = new Intent(Doctors.this,Ahc.class);
                    startActivity(j);
                }
                if (position==10){
                    Intent k = new Intent (Doctors.this,Mah.class);
                    startActivity(k);
                }


            }
        });
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
