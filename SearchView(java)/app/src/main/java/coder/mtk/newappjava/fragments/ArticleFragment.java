package coder.mtk.newappjava.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;

import java.util.Observer;

import coder.mtk.newappjava.R;
import coder.mtk.newappjava.fragments.adapter.NewsAdapter;
import coder.mtk.newappjava.viewmodel.NewsViewModel;

public class ArticleFragment extends Fragment {
    RecyclerView recyclerView;
    NewsViewModel newsViewModel;
    NewsAdapter newsAdapter;

    ProgressBar progressBar;

    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_article, container, false);
        // Inflate the layout for this fragment
        recyclerView = root.findViewById(R.id.recyclerview);
        progressBar = root.findViewById(R.id.loadingView);
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        newsViewModel.loadResult();
        newsAdapter = new NewsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsViewModel.getResult().observe(
                getViewLifecycleOwner(), news ->{
                    newsAdapter.updateArticle(news.getArticles());
                    recyclerView.setAdapter(newsAdapter);
                }
        );

        newsViewModel.getLoading().observe(
                getViewLifecycleOwner() , load ->{
                    if (load){
                        progressBar.setVisibility(View.VISIBLE);
                    }else {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
        );
        return root;
    }
//search view
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager)getActivity().getSystemService(Context.SEARCH_SERVICE);

        if(searchItem == null){
            searchView = (SearchView) searchItem.getActionView();
        }
        if(searchView != null){
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            searchView.setQueryHint("Search Latest News ...");
            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    Log.i("onQueryTextChange",s);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Log.i("onQueryTextSubmit",s);
                    return true;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }

    }
}