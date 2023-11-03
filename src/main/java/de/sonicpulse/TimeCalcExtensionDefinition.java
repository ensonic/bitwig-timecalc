package de.sonicpulse;

import java.util.UUID;

import com.bitwig.extension.api.PlatformType;
import com.bitwig.extension.controller.AutoDetectionMidiPortNamesList;
import com.bitwig.extension.controller.ControllerExtensionDefinition;
import com.bitwig.extension.controller.api.ControllerHost;

public class TimeCalcExtensionDefinition extends ControllerExtensionDefinition {
   private static final UUID DRIVER_ID = UUID.fromString("7b2deceb-a3d6-40be-a191-72ff727988f0");

   public TimeCalcExtensionDefinition() {
   }

   @Override
   public String getName() {
      return "TimeCalc";
   }

   @Override
   public String getAuthor() {
      return "ensonic";
   }

   @Override
   public String getVersion() {
      return "0.2";
   }

   @Override
   public UUID getId() {
      return DRIVER_ID;
   }

   @Override
   public String getHardwareVendor() {
      return "ensonic";
   }

   @Override
   public String getHardwareModel() {
      return "TimeCalc";
   }

   @Override
   public int getRequiredAPIVersion() {
      return 18;
   }

   @Override
   public int getNumMidiInPorts() {
      return 0;
   }

   @Override
   public int getNumMidiOutPorts() {
      return 0;
   }

   @Override
   public void listAutoDetectionMidiPortNames(final AutoDetectionMidiPortNamesList list,
         final PlatformType platformType) {
   }

   @Override
   public String getHelpFilePath() {
      // TODO: where is this used?
      return "https://github.com/ensonic/bitwig-timecalc/blob/main/README.md#timecalc";
   }

   @Override
   public TimeCalcExtension createInstance(final ControllerHost host) {
      return new TimeCalcExtension(this, host);
   }
}
