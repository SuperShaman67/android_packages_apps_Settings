/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.preference.CheckBoxPreference;
import android.util.Log;
import android.widget.Toast;

public class YugaSettings extends YugaSettingsPreferenceFragment {

    private static final String LOG_TAG = "YugaSettings";
    private static final String PREF_DOUBLE_TAP_TO_WAKE = "pabx_settings_double_tap";
    private static final String CF_DOUBLE_TAP_TO_WAKE = "/data/misc/."+PREF_DOUBLE_TAP_TO_WAKE;

    private CheckBoxPreference mDoubleTapToWake;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.yuga_settings);
        mDoubleTapToWake = (CheckBoxPreference) findPreference(PREF_DOUBLE_TAP_TO_WAKE);
        mDoubleTapToWake.setChecked(getYugaBool(CF_DOUBLE_TAP_TO_WAKE));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if(preference == mDoubleTapToWake) {
            setYugaBool(mDoubleTapToWake.isChecked(), CF_DOUBLE_TAP_TO_WAKE, PREF_DOUBLE_TAP_TO_WAKE);
        }
        return true;
    }

}
