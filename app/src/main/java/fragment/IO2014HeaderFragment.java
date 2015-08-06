package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.gena.bus_vn.R;
import com.example.gena.bus_vn.bus_list;
import com.example.gena.bus_vn.bus_schedule;
import com.example.gena.bus_vn.information;
import com.example.gena.bus_vn.traffic_patterns;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

import animator.IO2014HeaderAnimator;
import it.carlom.stikkyheader.core.StikkyHeaderBuilder;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;

public class IO2014HeaderFragment extends Fragment implements View.OnClickListener
{
    CardListView listView;
    Animation anim; // анимация для появление  float button action
    public IO2014HeaderFragment()
    {
        // Required empty public constructor
    }
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_io2014, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //анимация появления меню
        anim = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_anim);
        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.fab);
        fab.startAnimation(anim);
        fab.setOnClickListener(this);
        listView = (CardListView) getView().findViewById(R.id.myList);

    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.fab:
                try
                {
                    getActivity().finish();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        IO2014HeaderAnimator animator = new IO2014HeaderAnimator(getActivity());

        StikkyHeaderBuilder.stickTo(listView)
                .setHeader(R.id.header, (ViewGroup) getView())
                .minHeightHeaderDim(R.dimen.min_height_header_materiallike)
                .animator(animator)
                .build();
        populateListView();
    }
//Заполянем список карточек
    private void populateListView()
    {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i<4; i++)
        {

            switch (i)
            {
                case 0:
                    //Создаем карточку
                    Card card = new Card(getActivity());
                    //Создаем заголовок карточки
                    CardHeader header = new CardHeader(getActivity());
                    //Добавляем текст внутри карточки
                    CardThumbnail thumb = new CardThumbnail(getActivity());
                    header.setTitle("Расписания движения:");
                    card.setTitle("Расписания движения городских автобусов и троллейбусов");
                    card.addCardHeader(header);
                    thumb.setDrawableResource(R.drawable.bus);
                    //Обрабатываем нажатие на карточку
                    card.setOnClickListener(new Card.OnCardClickListener()
                    {
                        @Override
                        public void onClick(Card card, View view)
                        {
                            Intent intent = new Intent(getActivity(), bus_schedule.class);
                            startActivity(intent);
                            getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
                        }
                    });
                    card.addCardThumbnail(thumb);
                    cards.add(card);
                    break;
                case 1:
                    //Создаем карточку
                    card = new Card(getActivity());
                    //Создаем заголовок карточки
                    header = new CardHeader(getActivity());
                    //Добавляем текст внутри карточки
                    thumb = new CardThumbnail(getActivity());
                    header.setTitle("Схемы движения:");
                    card.setTitle("Схемы движения городских автобусов и троллейбусов");
                    card.addCardHeader(header);
                    thumb.setDrawableResource(R.drawable.shema);
                    //Обрабатываем нажатие на карточку
                    card.setOnClickListener(new Card.OnCardClickListener()
                    {
                        @Override
                        public void onClick(Card card, View view)
                        {
                            Intent intent = new Intent(getActivity(), traffic_patterns.class);
                            startActivity(intent);
                            getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);

                        }
                    });
                    card.addCardThumbnail(thumb);
                    cards.add(card);
                    break;
                case 2:
                    //Создаем карточку
                    card = new Card(getActivity());
                    //Создаем заголовок карточки
                    header = new CardHeader(getActivity());
                    //Добавляем текст внутри карточки
                    thumb = new CardThumbnail(getActivity());
                    header.setTitle("Предприятия перевозчики:");
                    card.setTitle("Контакты предприятий осуществляющих пассажирские перевозки в режиме городского транспортана на территории Великого Новгорода.");
                    card.addCardHeader(header);
                    thumb.setDrawableResource(R.drawable.bus_list);
                    //Обрабатываем нажатие на карточку
                    card.setOnClickListener(new Card.OnCardClickListener()
                    {
                        @Override
                        public void onClick(Card card, View view)
                        {
                            Intent intent = new Intent(getActivity(), bus_list.class);
                            startActivity(intent);
                            getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
                        }
                    });
                    card.addCardThumbnail(thumb);
                    cards.add(card);
                    break;
                case 3:
                    //Создаем карточку
                    card = new Card(getActivity());
                    //Создаем заголовок карточки
                    header = new CardHeader(getActivity());
                    //Добавляем текст внутри карточки
                    thumb = new CardThumbnail(getActivity());
                    header.setTitle("Справка:");
                    card.setTitle("Если у вас возникли проблемы или вопросы, вы можете обратиться в техническую поддержку.");
                    card.addCardHeader(header);
                    thumb.setDrawableResource(R.drawable.about);
                    //Обрабатываем нажатие на карточку
                    card.setOnClickListener(new Card.OnCardClickListener()
                    {
                        @Override
                        public void onClick(Card card, View view)
                        {
                            Intent intent = new Intent(getActivity(), information.class);
                            startActivity(intent);
                            getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);

                        }
                    });
                    card.addCardThumbnail(thumb);
                    cards.add(card);
                    break;
                default:
                    break;
            }

        }
        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(), cards);
        if (listView != null)
        {
            listView.setAdapter(mCardArrayAdapter);
        }
    }

}