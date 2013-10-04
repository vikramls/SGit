package me.sheimi.sgit.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.List;

import me.sheimi.sgit.R;
import me.sheimi.sgit.activities.ViewFileActivity;
import me.sheimi.sgit.utils.CodeUtils;
import me.sheimi.sgit.utils.RepoUtils;

/**
 * Created by sheimi on 8/16/13.
 */
public class ChooseLanguageDialog extends DialogFragment {

    private ViewFileActivity mActivity;
    private RepoUtils mRepoUtils;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        mActivity = (ViewFileActivity) getActivity();
        mRepoUtils = (RepoUtils) RepoUtils.getInstance(mActivity);

        final List<String> langs = CodeUtils.getLanguageList();
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);

        builder.setTitle(R.string.dialog_choose_language_title);
        builder.setItems(langs.toArray(new String[0]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                String lang = langs.get(position);
                String tag = CodeUtils.getLanguageTag(lang);
                mActivity.setLanguage(tag);
            }
        });

        return builder.create();
    }

}
