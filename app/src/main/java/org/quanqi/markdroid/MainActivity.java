package org.quanqi.markdroid;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

import org.androidannotations.annotations.AfterTextChange;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;
import org.quanqi.mark4j.Processor;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends Activity {

    public static final String TAG = "DroidMarkDown";

    @ViewById(R.id.sourceEditText)
    protected EditText sourceEditText;

    @ViewById(R.id.previewWebView)
    protected WebView preViewWebView;

    String css = "<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\" />\n";

    @AfterTextChange(R.id.sourceEditText)
    protected void preview() {
        String html = Processor.process(sourceEditText.getText().toString());
        WebSettings webSettings = preViewWebView.getSettings();
        webSettings.setDefaultTextEncodingName("utf-8");

        html = "<header>" + css + "</header>" + "<body>" + html + "</body>";

        preViewWebView.loadDataWithBaseURL("file:///android_asset/.",
                html, "text/html", "utf-8", null);

        Log.i(TAG, "HTML: " + html);
    }
}
