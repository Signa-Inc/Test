package com.example.mymassager;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messenger.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment {
    private String currentUserId;
    private FirebaseFirestore db;
    private List<Chat> chats;
    private ChatsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        db = FirebaseFirestore.getInstance();

        recyclerView = view.findViewById(R.id.recycler_chats);

        chats = new ArrayList<>();
        adapter = new ChatsAdapter(chats);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        loadChats();

        return view;
    }


    public void loadChats() {
        db.collection("chats")
                .addSnapshotListener((snapshots, e) -> {
                    chats.clear();

                    for (QueryDocumentSnapshot doc : snapshots) {
                        Chat chat = doc.toObject(Chat.class);
                        chat.setId(doc.getId());
                        chats.add(chat);
                    }

                    adapter.notifyDataSetChanged();
                });
    }
}
