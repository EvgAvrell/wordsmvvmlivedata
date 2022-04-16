package com.example.wordsmvvmlivedata.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.wordsmvvmlivedata.data.room.Word;
import com.example.wordsmvvmlivedata.data.room.WordDao;
import com.example.wordsmvvmlivedata.data.room.WordRoomDatabase;
import com.example.wordsmvvmlivedata.domain.WordRepository;

import java.util.List;

public class WordRepositoryRoomImpl implements WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepositoryRoomImpl(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.getWordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    @Override
    public LiveData<List<Word>> getAllWords() {
       return mAllWords;
    }

    @Override
    public void insert(Word word) {
    WordRoomDatabase.databaseWriteExecutor.execute(()->{
        mWordDao.insert(word);
    });
    }

    @Override
    public void deleteAll() {
    WordRoomDatabase.databaseWriteExecutor.execute(()->{
        mWordDao.deleteAll();
    });
    }
}
