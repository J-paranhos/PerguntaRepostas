package br.com.othonbatista.jogodeperguntas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.com.othonbatista.jogodeperguntas.databinding.FragmentCadastrarBinding;

public class CadastrarFragment extends Fragment {

    private FragmentCadastrarBinding binding;

    public CadastrarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    binding.buttonCadastrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          if  (  !(binding.editTextPergunta.getEditableText().toString().equals("") ||  binding.editTextResposta.getEditableText().toString().equals("") ) ) {

              Questoes PerguntaReposta = new Questoes();
              PerguntaReposta.setPergunta(binding.editTextPergunta.getEditableText().toString());
              PerguntaReposta.setResposta(binding.editTextResposta.getEditableText().toString());
              BancoDeDados.getBancoDeDadosInstancia(getContext()).QuestoesDao().insertAll(PerguntaReposta);

              binding.editTextPergunta.setText("");
              binding.editTextResposta.setText("");

              Toast myToast = Toast.makeText(getActivity(), "Pergunta cadastrada com sucesso!", Toast.LENGTH_SHORT);
              myToast.show();
          }
          else
          {

              Toast myToast = Toast.makeText(getActivity(), "Por favor, precisar peencher todos os valores", Toast.LENGTH_SHORT);
              myToast.show();
          }

        }
    });





    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentCadastrarBinding.inflate(inflater, container, false);
        return binding.getRoot();
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_cadastrar, container, false);
    }


}