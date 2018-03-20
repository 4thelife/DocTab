package com.example.antonio.doctab.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.adapters.CitasAdapter;
import com.example.antonio.doctab.adapters.DoctoresAdapter;
import com.example.antonio.doctab.fragments.interfaces.NavigationDrawerInterface;
import com.example.antonio.doctab.models.Citas;
import com.example.antonio.doctab.models.Usuarios;
import com.example.antonio.doctab.services.SharedPreferencesService;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by GIGABYTE on 06/03/2018.
 */

public class InicioFragment extends Fragment {

    private static Usuarios _SESSION_USER;

    private static NavigationDrawerInterface activityInterface;
    public static LinearLayout linearLayout;

    /**
     * Declaracion de los elementos de la vista
     */
    private static List<Citas> dataList;
    private static RecyclerView recyclerView;
    public static CitasAdapter adapter;
    TextView vista;
    /**
     * Declaraciones de firebase
     **/
    private FirebaseDatabase database;
    private DatabaseReference drCitas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        vista = (TextView) view.findViewById(R.id.txt_inicio);

        _SESSION_USER = SharedPreferencesService.getUsuarioActual(getContext());
        linearLayout = (LinearLayout) view.findViewById(R.id.view_no_resultados);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_citas);

        database = FirebaseDatabase.getInstance();
        switch (_SESSION_USER.getTipoDeUsuario()){
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_PACIENTE:
                drCitas = database.getReference(Constants.FB_KEY_MAIN_CITAS);
                vista.setText("Inicio en modo paciente");
                break;
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR:
                drCitas = database.getReference(Constants.FB_KEY_MAIN_CITAS)
                        .child(_SESSION_USER.getFirebaseId());
                vista.setText("Inicio en modo doctor");
                break;
        }


        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        switch (_SESSION_USER.getTipoDeUsuario()){
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR:
                listadoInicioDoctor();
                break;
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_PACIENTE:
                listadoInicioPaciente();
                break;
        }

    }

    private void listadoInicioDoctor() {

    }

    private void listadoInicioPaciente() {

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
