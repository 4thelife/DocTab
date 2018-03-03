package com.example.antonio.doctab.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.Utils.Constants;
import com.example.antonio.doctab.models.Usuarios;


public class MainPanelFragment extends Fragment {

    private static Usuarios _SESSION_USER;
    public FragmentTransaction mainFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_panel, container, false);

        _SESSION_USER = (Usuarios) getActivity().getIntent().getSerializableExtra(Constants.KEY_SESSION_USER);

        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        onPreRender();
    }

    /**
     * Carga los paneles iniciales
     **/
    public void onPreRender() {
        this.onPreRenderSessionPanel();
    }

    /**
     * Carga los paneles por el tipo de usuario
     **/
    public void onPreRenderSessionPanel() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mainFragment = fragmentManager.beginTransaction();
    //miperfil_general_doctor_privado_fragment
        /*
        switch (_SESSION_USER.getTipoDeUsuario()) {
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_DOCTOR:
                mainFragment.replace(R.id.panel_perfil_general_container, new PanelPerfilGeneralFragment(), Constants.PANEL_PERFIL_GENERAL_CONTAINER);
                mainFragment.replace(R.id.panel_bodegas_container, new PanelBodegasFragment(), Constants.PANEL_BODEGAS_CONTAINER);
                break;
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_TRANSPORTISTA:
                mainFragment.replace(R.id.panel_fletes_container, new PanelFletesFragment(), Constants.PANEL_FLETES_CONTAINER);
                //mainFragment.replace(R.id.panel_fletes_rapidos_container, new PanelFletesRapidosFragment(), Constants.PANEL_FLETES_RAPIDOS_CONTAINER);
                mainFragment.replace(R.id.panel_choferes_container, new PanelChoferesFragment(), Constants.PANEL_CHOFERES_CONTAINER);
                mainFragment.replace(R.id.panel_tractores_container, new PanelTractoresFragment(), Constants.PANEL_TRACTORES_CONTAINER);
                mainFragment.replace(R.id.panel_remolques_container, new PanelRemolquesFragment(), Constants.PANEL_REMOLQUES_CONTAINER);
                break;
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_CHOFER:
                mainFragment.replace(R.id.panel_fletes_container, new PanelFletesFragment(), Constants.PANEL_FLETES_CONTAINER);
                //mainFragment.replace(R.id.panel_fletes_rapidos_container, new PanelFletesRapidosFragment(), Constants.PANEL_FLETES_CONTAINER);
                mainFragment.replace(R.id.panel_por_iniciar_container, new ListadoFletesPorIniciarFragment(), Constants.FRAGMENT_LISTADO_FLETES_POR_INICIAR);
                break;
            case Constants.FB_KEY_ITEM_TIPO_USUARIO_COLABORADOR:
                mainFragment.replace(R.id.panel_fletes_container, new PanelFletesFragment(), Constants.PANEL_FLETES_CONTAINER);
                //mainFragment.replace(R.id.panel_fletes_rapidos_container, new PanelFletesRapidosFragment(), Constants.PANEL_FLETES_RAPIDOS_CONTAINER);
                mainFragment.replace(R.id.panel_clientes_container, new PanelClientesFragment(), Constants.PANEL_CLIENTES_CONTAINER);
                mainFragment.replace(R.id.panel_bodegas_container, new PanelBodegasFragment(), Constants.PANEL_BODEGAS_CONTAINER);
                mainFragment.replace(R.id.panel_transportistas_container, new PanelTransportistasFragment(), Constants.PANEL_TRANSPORTISTAS_CONTAINER);
                mainFragment.replace(R.id.panel_choferes_container, new PanelChoferesFragment(), Constants.PANEL_CHOFERES_CONTAINER);
                mainFragment.replace(R.id.panel_tractores_container, new PanelTractoresFragment(), Constants.PANEL_TRACTORES_CONTAINER);
                mainFragment.replace(R.id.panel_remolques_container, new PanelRemolquesFragment(), Constants.PANEL_REMOLQUES_CONTAINER);
                break;
            default:
                mainFragment.replace(R.id.panel_fletes_container, new PanelFletesFragment(), Constants.PANEL_FLETES_CONTAINER);
                //mainFragment.replace(R.id.panel_por_iniciar_container, new ListadoFletesPorIniciarFragment(), Constants.FRAGMENT_LISTADO_FLETES_POR_INICIAR);
                //mainFragment.replace(R.id.panel_fletes_rapidos_container, new PanelFletesRapidosFragment(), Constants.PANEL_FLETES_RAPIDOS_CONTAINER);
                mainFragment.replace(R.id.panel_colaboradores_container, new PanelColaboradoresFragment(), Constants.PANEL_COLABORADORES_CONTAINER);
                mainFragment.replace(R.id.panel_clientes_container, new PanelClientesFragment(), Constants.PANEL_CLIENTES_CONTAINER);
                mainFragment.replace(R.id.panel_bodegas_container, new PanelBodegasFragment(), Constants.PANEL_BODEGAS_CONTAINER);
                mainFragment.replace(R.id.panel_transportistas_container, new PanelTransportistasFragment(), Constants.PANEL_TRANSPORTISTAS_CONTAINER);
                mainFragment.replace(R.id.panel_choferes_container, new PanelChoferesFragment(), Constants.PANEL_CHOFERES_CONTAINER);
                mainFragment.replace(R.id.panel_tractores_container, new PanelTractoresFragment(), Constants.PANEL_TRACTORES_CONTAINER);
                mainFragment.replace(R.id.panel_remolques_container, new PanelRemolquesFragment(), Constants.PANEL_REMOLQUES_CONTAINER);
                break;
        }
        */
        mainFragment.commit();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {

        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "debe implementar");
        }
    }
}
