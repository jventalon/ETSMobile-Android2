package ca.etsmtl.applets.etsmobile.ui.fragment;

import java.util.Vector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
<<<<<<< HEAD
import ca.etsmtl.applets.etsmobile.ApplicationManager;
import ca.etsmtl.applets.etsmobile.http.DataManager;
import ca.etsmtl.applets.etsmobile.http.DataManager.SignetMethods;
import ca.etsmtl.applets.etsmobile.model.ListeDeCours;
import ca.etsmtl.applets.etsmobile.model.ListeDeSessions;
=======
>>>>>>> FETCH_HEAD
import ca.etsmtl.applets.etsmobile.ui.adapter.NoteAdapter;
import ca.etsmtl.applets.etsmobile.ui.adapter.NotesSessionItem;
import ca.etsmtl.applets.etsmobile.ui.adapter.SessionCoteAdapter;
import ca.etsmtl.applets.etsmobile.ui.adapter.SessionCoteItem;
import ca.etsmtl.applets.etsmobile2.R;

import com.octo.android.robospice.persistence.exception.SpiceException;

/**
 * Created by Laurence
 */
public class NotesFragment extends HttpFragment {

	private ListView mListView;
	private NoteAdapter adapter;
	
	private SessionCoteItem[] sessionCoteItemArray;
	private NotesSessionItem[] notesSession;
	
	private ListeDeCours listeDeCours;
	private ListeDeSessions listeDeSessions;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Overrides
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
		View v = inflater.inflate(R.layout.activity_note, container, false);
		mListView = (ListView) v.findViewById(R.id.activity_note_listview);
		return v;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		DataManager datamanager = DataManager.getInstance(getActivity());
		datamanager.getDataFromSignet(SignetMethods.LIST_COURS, ApplicationManager.userCredentials, this, "");
		datamanager.getDataFromSignet(SignetMethods.LIST_SESSION, ApplicationManager.userCredentials, this, "");
	}

	@Override
	void updateUI() {
	}

	@Override
	public void onRequestFailure(SpiceException e) {

	}

	@Override
	public void onRequestSuccess(Object o) {

		if (o != null)
			if (o instanceof ListeDeCours) {
			    listeDeCours = (ListeDeCours)o;
				refreshList();
			}else if( o instanceof ListeDeSessions){
				listeDeSessions = (ListeDeSessions)o;
				refreshList();
			}
	}
	
	
	private void refreshList(){
		if(listeDeCours!=null && listeDeSessions !=null){
			if(listeDeCours.liste.size()!=0){
				sessionCoteItemArray= new SessionCoteItem[listeDeCours.liste.size()];
				
				Vector<SessionCoteItem> vector = new Vector<SessionCoteItem>();
				Vector<NotesSessionItem> vectoNoteSession = new Vector<NotesSessionItem>();
				String sessionString =""; 
				int index =0;
				for (int i=0;i<listeDeCours.liste.size();i++) {
					//Pour initialiser la première session
					if(sessionString.equals("")){
						sessionString = listeDeCours.liste.get(i).session;
					}
					//Permet le regroupement par session, on ajoute le vecteur des cours dans la session
					if(!sessionString.equals(listeDeCours.liste.get(i).session) ||i==listeDeCours.liste.size()-1){
						if(i==listeDeCours.liste.size()-1 && sessionString.equals(listeDeCours.liste.get(i).session)){
							vector.add(new SessionCoteItem(listeDeCours.liste.get(i).sigle, listeDeCours.liste.get(i).cote, listeDeCours.liste.get(i).groupe));	
						}
						sessionCoteItemArray= new SessionCoteItem[vector.size()];
						int j=0;
						for (SessionCoteItem sessionCoteItem : vector) {
							sessionCoteItemArray[j] = sessionCoteItem;
							j++;
						}
						vectoNoteSession.add(new NotesSessionItem(listeDeSessions.liste.get(index).auLong , new SessionCoteAdapter(getActivity(), sessionCoteItemArray)));
						index+=1;
						vector.clear();
						//Dans le cas que le dernier élément est dans une autre session.
						if(i==listeDeCours.liste.size()-1 && !sessionString.equals(listeDeCours.liste.get(i).session)){
							SessionCoteItem sessionCoteItem=new SessionCoteItem(listeDeCours.liste.get(i).sigle, listeDeCours.liste.get(i).cote, listeDeCours.liste.get(i).groupe);
							vectoNoteSession.add(new NotesSessionItem(listeDeSessions.liste.get(index).auLong , new SessionCoteAdapter(getActivity(), new SessionCoteItem[]{sessionCoteItem})));
							sessionString = listeDeCours.liste.get(i).session;
						}
						sessionString = listeDeCours.liste.get(i).session;
					}
					vector.add(new SessionCoteItem(listeDeCours.liste.get(i).sigle, listeDeCours.liste.get(i).cote, listeDeCours.liste.get(i).groupe));
				}
				int i = vectoNoteSession.size()-1;
				notesSession = new NotesSessionItem[vectoNoteSession.size()];
				for (NotesSessionItem notesSessionItem : vectoNoteSession) {
					notesSession[i] = notesSessionItem;
					i--;
				}
				getActivity().runOnUiThread(new Runnable(){
	
					@Override
					public void run() {
						adapter = new NoteAdapter(getActivity(), R.layout.row_note_menu, notesSession);
						mListView.setAdapter(adapter);
					}
					
				});
			}
		}

	}

}
