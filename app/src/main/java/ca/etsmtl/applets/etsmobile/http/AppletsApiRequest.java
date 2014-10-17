package ca.etsmtl.applets.etsmobile.http;

import android.content.Context;

import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;

import ca.etsmtl.applets.etsmobile.model.EventList;
import ca.etsmtl.applets.etsmobile2.R;


public class AppletsApiRequest extends SpringAndroidSpiceRequest<EventList> {

    private Context context;
    private String startDate;
    private String endDate;

    public AppletsApiRequest(Context context, String startDate, String endDate) {
        super(EventList.class);
        this.context = context;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public EventList loadDataFromNetwork() throws Exception {

        String url = context.getString(R.string.applets_api_calendar, "ets", startDate, endDate);
        return getRestTemplate().getForObject(url, EventList.class);
    }
}
