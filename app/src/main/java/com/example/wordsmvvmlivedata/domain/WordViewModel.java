package com.example.wordsmvvmlivedata.domain;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wordsmvvmlivedata.data.repository.WordRepositoryRoomImpl;
import com.example.wordsmvvmlivedata.data.room.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private final LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepositoryRoomImpl(application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getmAllWords() {return mAllWords;}

    public void insert(Word word) {
        mRepository.insert(word);
    }

    public void deleteAll(){
        mRepository.deleteAll();
        Toast.makeText(getApplication(), "All words have been removed", Toast.LENGTH_SHORT).show();
    }
}
