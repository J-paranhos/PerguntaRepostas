package br.com.othonbatista.jogodeperguntas;

import android.icu.text.SymbolTable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import br.com.othonbatista.jogodeperguntas.databinding.FragmentJogarBinding;

public class JogarFragment extends Fragment {

    private FragmentJogarBinding binding;
    private List<Questoes> Pergunta;
    private int UltimoElemento;
    private int AtuaElemento = 0;

    public JogarFragment() {




    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void onStart() {
        super.onStart();

        Pergunta = BancoDeDados.getBancoDeDadosInstancia(getContext()).QuestoesDao().getAll();



        if ( !(Pergunta.isEmpty()) ){
            UltimoElemento = Pergunta.size();
            Random random = new java.util.Random();
            AtuaElemento = random.nextInt(UltimoElemento);
            binding.textViewPergunta.setText(Pergunta.get(AtuaElemento).pergunta);
        }





    }






    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonPular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // if (AtuaElemento != UltimoElemento -1 ) {
                //    AtuaElemento++;


                    Random random = new java.util.Random();
                    AtuaElemento = random.nextInt(UltimoElemento);
                    binding.textViewPergunta.setText(Pergunta.get(AtuaElemento).pergunta);
                    binding.textViewResposta.setText("");
             //   }
               // else
               // {

                //    Toast myToast = Toast.makeText(getActivity(), "Ultima pergunta!", Toast.LENGTH_SHORT);
              //      myToast.show();
              //  }

            }
        });




        binding.buttonExibirResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            binding.textViewResposta.setText(Pergunta.get(AtuaElemento).resposta);

            }
        });






    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJogarBinding.inflate(inflater, container, false);
        return binding.getRoot();
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_jogar, container, false);
    }





    }