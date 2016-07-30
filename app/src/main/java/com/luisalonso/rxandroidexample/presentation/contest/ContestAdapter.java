package com.luisalonso.rxandroidexample.presentation.contest;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisalonso.rxandroidexample.R;
import com.luisalonso.rxandroidexample.databinding.ItemProblemBinding;
import com.luisalonso.rxandroidexample.domain.Problem;

import java.util.List;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class ContestAdapter extends RecyclerView.Adapter<ContestAdapter.ProblemViewHolder> {

    private List<Problem> problems;

    public ContestAdapter(List<Problem> problems) {
        super();
        this.problems = problems;
    }

    static class ProblemViewHolder extends RecyclerView.ViewHolder {
        private ItemProblemBinding binding;

        public ProblemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ItemProblemBinding getBinding() {
            return binding;
        }
    }

    @Override
    public ProblemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_problem, parent, false);
        return new ProblemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProblemViewHolder holder, int position) {
        final Problem problem = problems.get(position);
        holder.getBinding().setProblem(problem);
    }

    @Override
    public int getItemCount() {
        return (problems != null) ? problems.size() : 0;
    }
}
