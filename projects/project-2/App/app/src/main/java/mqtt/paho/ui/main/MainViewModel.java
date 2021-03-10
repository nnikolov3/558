package mqtt.paho.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

  // These values are updated continually
  // the moment the data is updated
  public MutableLiveData<String> temp_in_c = new MutableLiveData<>();
  public MutableLiveData<String> temp_in_f = new MutableLiveData<>();
  public MutableLiveData<String> humidity = new MutableLiveData<>();
}