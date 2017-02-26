package hu.pe.routengo.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.pe.routengo.R;
import hu.pe.routengo.adapter.InterestAdapter;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;


public class InterestFragment extends Fragment {

    private RecyclerView recyclerView;
    private Single<InterestAdapter> single;
    private Disposable disposable;

    public InterestFragment() {
    }

    public InterestFragment(Single<InterestAdapter> single) {
        this.single = single;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.intro_slide_interests, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_intro_interests);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        disposable = single.subscribe(recyclerView::setAdapter);

        return view;
    }

    public void setSingle() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        disposable.dispose();
        super.onDetach();
    }
}
