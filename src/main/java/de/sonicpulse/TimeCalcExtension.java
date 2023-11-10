package de.sonicpulse;

import com.bitwig.extension.controller.api.ControllerHost;
import com.bitwig.extension.controller.api.DocumentState;
import com.bitwig.extension.controller.api.Parameter;
import com.bitwig.extension.controller.api.SettableEnumValue;
import com.bitwig.extension.controller.api.SettableStringValue;
import com.bitwig.extension.controller.ControllerExtension;

public class TimeCalcExtension extends ControllerExtension {
   private static final String[] typeOpts = { "normal", "dotted", "triplets" };
   private static final int N = 7;

   private ControllerHost host;
   private DocumentState documentState;
   private Parameter tempo;

   private SettableEnumValue type;
   private SettableStringValue[] time = new SettableStringValue[N];

   protected TimeCalcExtension(final TimeCalcExtensionDefinition definition, final ControllerHost host) {
      super(definition, host);
   }

   private void log(String s) {
      host.println(s);
      java.lang.System.out.println(s);
   }

   @Override
   public void init() {
      host = getHost();
      documentState = host.getDocumentState();

      // Panel UI
      // The 2nd parameters "category" seems to be used to oder things
      // Ideally we'd format the notes into a grid, but there seem to be no
      // option for it. As an alternative we should use another enum to switch
      // between "time" and "frequency"
      type = documentState.getEnumSetting("type", "opts", typeOpts, typeOpts[0]);
      int f = 1;
      for (int i = 0; i < N; i++) {
         time[i] = documentState.getStringSetting(String.format("1/%d", f), "out", 20, "");
         f *= 2;
      }

      tempo = host.createTransport().tempo();
      tempo.value().addValueObserver(value -> onTempoChanged(value));
      type.addValueObserver(value -> onTempoChanged(tempo.get()));

      log("TimeCalc initialized");
   }

   private void onTempoChanged(double value) {
      if (value < 0.0 || value > 1.0) {
         log(String.format("Out of range value for tempo %f", value));
         return;
      }
      // value is 0.0 ... 1.0 - no idea if I can obtain the min/max from somewhere
      double bpm = 20.0 + 646.0 * value;
      // log(String.format("%.2f bpm", bpm));
      // get note type factor
      double fc = 1.0;
      switch (type.get()) {
         case "dotted":
            fc = 1.5;
            break;
         case "triplets":
            fc = 1.0 / 1.5;
            break;
      }
      // recalc times and frequencies
      // 60 bpm: 1/1 == 4000.0 ms | 0.25 Hz
      // 120 bpm: 1/1 == 2000.0 ms | 0.5 Hz
      // 240 bpm: 1/1 == 1000.0 ms | 1.0 Hz
      double s = (4.0 * 60.0 / bpm) * fc;
      for (int i = 0; i < N; i++) {
         // This marks the song as dirty :/
         // https://github.com/ensonic/bitwig-timecalc/issues/4
         time[i].set(String.format("%.2f ms | %.2f Hz", s * 1000.0, 1.0 / s));
         s /= 2.0;
      }
   }

   @Override
   public void exit() {
      // TODO: Perform any cleanup once the driver exits
   }

   @Override
   public void flush() {
      // TODO Send any updates you need here.
   }

}
