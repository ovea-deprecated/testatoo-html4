/**
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.testatoo.cartridge.input;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testatoo.cartridge.WebTest;
import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.cartridge.html4.element.Div;
import org.testatoo.core.ConditionChain;
import org.testatoo.core.EvaluatorHolder;
import org.testatoo.core.condition.TimerCondition;
import org.testatoo.core.input.KeyModifier;
import org.testatoo.core.input.Keyboard;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.input.Key.*;
import static org.testatoo.core.input.KeyModifier.*;

public class FullKeyboardTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        HtmlEvaluator htmlEvaluator = (HtmlEvaluator) EvaluatorHolder.get();
        ConditionChain conditionChain = (ConditionChain) htmlEvaluator.getWaitingCondition();
        conditionChain.addCondition(new TimerCondition(200));

        page().open("AllKeysTest.html");
    }

    @Test
    public void can_test_CONTROL_key_modifier() {
        Keyboard.keyDown(KeyModifier.CONTROL);

        assertThat(component(Div.class, "_Ctrl_a").classname(), not(containsString("dirty")));
        Keyboard.type("a");
        assertThat(component(Div.class, "_Ctrl_a").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_b").classname(), not(containsString("dirty")));
        Keyboard.type("b");
        assertThat(component(Div.class, "_Ctrl_b").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_c").classname(), not(containsString("dirty")));
        Keyboard.type("c");
        assertThat(component(Div.class, "_Ctrl_c").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_d").classname(), not(containsString("dirty")));
        Keyboard.type("d");
        assertThat(component(Div.class, "_Ctrl_d").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_e").classname(), not(containsString("dirty")));
        Keyboard.type("e");
        assertThat(component(Div.class, "_Ctrl_e").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f").classname(), not(containsString("dirty")));
        Keyboard.type("f");
        assertThat(component(Div.class, "_Ctrl_f").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_g").classname(), not(containsString("dirty")));
        Keyboard.type("g");
        assertThat(component(Div.class, "_Ctrl_g").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_h").classname(), not(containsString("dirty")));
        Keyboard.type("h");
        assertThat(component(Div.class, "_Ctrl_h").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_i").classname(), not(containsString("dirty")));
        Keyboard.type("i");
        assertThat(component(Div.class, "_Ctrl_i").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_j").classname(), not(containsString("dirty")));
        Keyboard.type("j");
        assertThat(component(Div.class, "_Ctrl_j").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_k").classname(), not(containsString("dirty")));
        Keyboard.type("k");
        assertThat(component(Div.class, "_Ctrl_k").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_l").classname(), not(containsString("dirty")));
        Keyboard.type("l");
        assertThat(component(Div.class, "_Ctrl_l").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_m").classname(), not(containsString("dirty")));
        Keyboard.type("m");
        assertThat(component(Div.class, "_Ctrl_m").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_n").classname(), not(containsString("dirty")));
        Keyboard.type("n");
        assertThat(component(Div.class, "_Ctrl_n").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_o").classname(), not(containsString("dirty")));
        Keyboard.type("o");
        assertThat(component(Div.class, "_Ctrl_o").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_p").classname(), not(containsString("dirty")));
        Keyboard.type("p");
        assertThat(component(Div.class, "_Ctrl_p").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_q").classname(), not(containsString("dirty")));
        Keyboard.type("q");
        assertThat(component(Div.class, "_Ctrl_q").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_r").classname(), not(containsString("dirty")));
        Keyboard.type("r");
        assertThat(component(Div.class, "_Ctrl_r").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_s").classname(), not(containsString("dirty")));
        Keyboard.type("s");
        assertThat(component(Div.class, "_Ctrl_s").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_t").classname(), not(containsString("dirty")));
        Keyboard.type("t");
        assertThat(component(Div.class, "_Ctrl_t").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_u").classname(), not(containsString("dirty")));
        Keyboard.type("u");
        assertThat(component(Div.class, "_Ctrl_u").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_v").classname(), not(containsString("dirty")));
        Keyboard.type("v");
        assertThat(component(Div.class, "_Ctrl_v").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_w").classname(), not(containsString("dirty")));
        Keyboard.type("w");
        assertThat(component(Div.class, "_Ctrl_w").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_x").classname(), not(containsString("dirty")));
        Keyboard.type("x");
        assertThat(component(Div.class, "_Ctrl_x").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_y").classname(), not(containsString("dirty")));
        Keyboard.type("y");
        assertThat(component(Div.class, "_Ctrl_y").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_z").classname(), not(containsString("dirty")));
        Keyboard.type("z");
        assertThat(component(Div.class, "_Ctrl_z").classname(), containsString("dirty"));

        Keyboard.release();
    }

    @Test
    public void can_test_SHIFT_key_modifier() {
        Keyboard.keyDown(SHIFT);

        assertThat(component(Div.class, "_Shift_a").classname(), not(containsString("dirty")));
        Keyboard.type("a");
        assertThat(component(Div.class, "_Shift_a").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_b").classname(), not(containsString("dirty")));
        Keyboard.type("b");
        assertThat(component(Div.class, "_Shift_b").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_c").classname(), not(containsString("dirty")));
        Keyboard.type("c");
        assertThat(component(Div.class, "_Shift_c").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_d").classname(), not(containsString("dirty")));
        Keyboard.type("d");
        assertThat(component(Div.class, "_Shift_d").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_e").classname(), not(containsString("dirty")));
        Keyboard.type("e");
        assertThat(component(Div.class, "_Shift_e").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f").classname(), not(containsString("dirty")));
        Keyboard.type("f");
        assertThat(component(Div.class, "_Shift_f").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_g").classname(), not(containsString("dirty")));
        Keyboard.type("g");
        assertThat(component(Div.class, "_Shift_g").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_h").classname(), not(containsString("dirty")));
        Keyboard.type("h");
        assertThat(component(Div.class, "_Shift_h").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_i").classname(), not(containsString("dirty")));
        Keyboard.type("i");
        assertThat(component(Div.class, "_Shift_i").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_j").classname(), not(containsString("dirty")));
        Keyboard.type("j");
        assertThat(component(Div.class, "_Shift_j").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_k").classname(), not(containsString("dirty")));
        Keyboard.type("k");
        assertThat(component(Div.class, "_Shift_k").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_l").classname(), not(containsString("dirty")));
        Keyboard.type("l");
        assertThat(component(Div.class, "_Shift_l").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_m").classname(), not(containsString("dirty")));
        Keyboard.type("m");
        assertThat(component(Div.class, "_Shift_m").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_n").classname(), not(containsString("dirty")));
        Keyboard.type("n");
        assertThat(component(Div.class, "_Shift_n").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_o").classname(), not(containsString("dirty")));
        Keyboard.type("o");
        assertThat(component(Div.class, "_Shift_o").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_p").classname(), not(containsString("dirty")));
        Keyboard.type("p");
        assertThat(component(Div.class, "_Shift_p").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_q").classname(), not(containsString("dirty")));
        Keyboard.type("q");
        assertThat(component(Div.class, "_Shift_q").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_r").classname(), not(containsString("dirty")));
        Keyboard.type("r");
        assertThat(component(Div.class, "_Shift_r").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_s").classname(), not(containsString("dirty")));
        Keyboard.type("s");
        assertThat(component(Div.class, "_Shift_s").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_t").classname(), not(containsString("dirty")));
        Keyboard.type("t");
        assertThat(component(Div.class, "_Shift_t").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_u").classname(), not(containsString("dirty")));
        Keyboard.type("u");
        assertThat(component(Div.class, "_Shift_u").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_v").classname(), not(containsString("dirty")));
        Keyboard.type("v");
        assertThat(component(Div.class, "_Shift_v").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_w").classname(), not(containsString("dirty")));
        Keyboard.type("w");
        assertThat(component(Div.class, "_Shift_w").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_x").classname(), not(containsString("dirty")));
        Keyboard.type("x");
        assertThat(component(Div.class, "_Shift_x").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_y").classname(), not(containsString("dirty")));
        Keyboard.type("y");
        assertThat(component(Div.class, "_Shift_y").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_z").classname(), not(containsString("dirty")));
        Keyboard.type("z");
        assertThat(component(Div.class, "_Shift_z").classname(), containsString("dirty"));

        Keyboard.release();
    }

    @Test
    public void can_test_ALT_key_modifier() {
        Keyboard.keyDown(ALT);

        assertThat(component(Div.class, "_Alt_a").classname(), not(containsString("dirty")));
        Keyboard.type("a");
        assertThat(component(Div.class, "_Alt_a").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_b").classname(), not(containsString("dirty")));
        Keyboard.type("b");
        assertThat(component(Div.class, "_Alt_b").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_c").classname(), not(containsString("dirty")));
        Keyboard.type("c");
        assertThat(component(Div.class, "_Alt_c").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_d").classname(), not(containsString("dirty")));
        Keyboard.type("d");
        assertThat(component(Div.class, "_Alt_d").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_e").classname(), not(containsString("dirty")));
        Keyboard.type("e");
        assertThat(component(Div.class, "_Alt_e").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f").classname(), not(containsString("dirty")));
        Keyboard.type("f");
        assertThat(component(Div.class, "_Alt_f").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_g").classname(), not(containsString("dirty")));
        Keyboard.type("g");
        assertThat(component(Div.class, "_Alt_g").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_h").classname(), not(containsString("dirty")));
        Keyboard.type("h");
        assertThat(component(Div.class, "_Alt_h").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_i").classname(), not(containsString("dirty")));
        Keyboard.type("i");
        assertThat(component(Div.class, "_Alt_i").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_j").classname(), not(containsString("dirty")));
        Keyboard.type("j");
        assertThat(component(Div.class, "_Alt_j").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_k").classname(), not(containsString("dirty")));
        Keyboard.type("k");
        assertThat(component(Div.class, "_Alt_k").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_l").classname(), not(containsString("dirty")));
        Keyboard.type("l");
        assertThat(component(Div.class, "_Alt_l").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_m").classname(), not(containsString("dirty")));
        Keyboard.type("m");
        assertThat(component(Div.class, "_Alt_m").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_n").classname(), not(containsString("dirty")));
        Keyboard.type("n");
        assertThat(component(Div.class, "_Alt_n").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_o").classname(), not(containsString("dirty")));
        Keyboard.type("o");
        assertThat(component(Div.class, "_Alt_o").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_p").classname(), not(containsString("dirty")));
        Keyboard.type("p");
        assertThat(component(Div.class, "_Alt_p").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_q").classname(), not(containsString("dirty")));
        Keyboard.type("q");
        assertThat(component(Div.class, "_Alt_q").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_r").classname(), not(containsString("dirty")));
        Keyboard.type("r");
        assertThat(component(Div.class, "_Alt_r").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_s").classname(), not(containsString("dirty")));
        Keyboard.type("s");
        assertThat(component(Div.class, "_Alt_s").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_t").classname(), not(containsString("dirty")));
        Keyboard.type("t");
        assertThat(component(Div.class, "_Alt_t").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_u").classname(), not(containsString("dirty")));
        Keyboard.type("u");
        assertThat(component(Div.class, "_Alt_u").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_v").classname(), not(containsString("dirty")));
        Keyboard.type("v");
        assertThat(component(Div.class, "_Alt_v").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_w").classname(), not(containsString("dirty")));
        Keyboard.type("w");
        assertThat(component(Div.class, "_Alt_w").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_x").classname(), not(containsString("dirty")));
        Keyboard.type("x");
        assertThat(component(Div.class, "_Alt_x").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_y").classname(), not(containsString("dirty")));
        Keyboard.type("y");
        assertThat(component(Div.class, "_Alt_y").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_z").classname(), not(containsString("dirty")));
        Keyboard.type("z");
        assertThat(component(Div.class, "_Alt_z").classname(), containsString("dirty"));

        Keyboard.release();
    }

    @Test
    public void generalKeyTest() {
        assertThat(component(Div.class, "_a").classname(), not(containsString("dirty")));
        Keyboard.type("a");
        assertThat(component(Div.class, "_a").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_b").classname(), not(containsString("dirty")));
        Keyboard.type("b");
        assertThat(component(Div.class, "_b").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_c").classname(), not(containsString("dirty")));
        Keyboard.type("c");
        assertThat(component(Div.class, "_c").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_d").classname(), not(containsString("dirty")));
        Keyboard.type("d");
        assertThat(component(Div.class, "_d").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_e").classname(), not(containsString("dirty")));
        Keyboard.type("e");
        assertThat(component(Div.class, "_e").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f").classname(), not(containsString("dirty")));
        Keyboard.type("f");
        assertThat(component(Div.class, "_f").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_g").classname(), not(containsString("dirty")));
        Keyboard.type("g");
        assertThat(component(Div.class, "_g").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_h").classname(), not(containsString("dirty")));
        Keyboard.type("h");
        assertThat(component(Div.class, "_h").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_i").classname(), not(containsString("dirty")));
        Keyboard.type("i");
        assertThat(component(Div.class, "_i").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_j").classname(), not(containsString("dirty")));
        Keyboard.type("j");
        assertThat(component(Div.class, "_j").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_k").classname(), not(containsString("dirty")));
        Keyboard.type("k");
        assertThat(component(Div.class, "_k").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_l").classname(), not(containsString("dirty")));
        Keyboard.type("l");
        assertThat(component(Div.class, "_l").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_m").classname(), not(containsString("dirty")));
        Keyboard.type("m");
        assertThat(component(Div.class, "_m").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_n").classname(), not(containsString("dirty")));
        Keyboard.type("n");
        assertThat(component(Div.class, "_n").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_o").classname(), not(containsString("dirty")));
        Keyboard.type("o");
        assertThat(component(Div.class, "_o").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_p").classname(), not(containsString("dirty")));
        Keyboard.type("p");
        assertThat(component(Div.class, "_p").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_q").classname(), not(containsString("dirty")));
        Keyboard.type("q");
        assertThat(component(Div.class, "_q").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_r").classname(), not(containsString("dirty")));
        Keyboard.type("r");
        assertThat(component(Div.class, "_r").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_s").classname(), not(containsString("dirty")));
        Keyboard.type("s");
        assertThat(component(Div.class, "_s").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_t").classname(), not(containsString("dirty")));
        Keyboard.type("t");
        assertThat(component(Div.class, "_t").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_u").classname(), not(containsString("dirty")));
        Keyboard.type("u");
        assertThat(component(Div.class, "_u").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_v").classname(), not(containsString("dirty")));
        Keyboard.type("v");
        assertThat(component(Div.class, "_v").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_w").classname(), not(containsString("dirty")));
        Keyboard.type("w");
        assertThat(component(Div.class, "_w").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_x").classname(), not(containsString("dirty")));
        Keyboard.type("x");
        assertThat(component(Div.class, "_x").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_y").classname(), not(containsString("dirty")));
        Keyboard.type("y");
        assertThat(component(Div.class, "_y").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_z").classname(), not(containsString("dirty")));
        Keyboard.type("z");
        assertThat(component(Div.class, "_z").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f1").classname(), not(containsString("dirty")));
        Keyboard.press(F1);
        assertThat(component(Div.class, "_f1").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f2").classname(), not(containsString("dirty")));
        Keyboard.press(F2);
        assertThat(component(Div.class, "_f2").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f3").classname(), not(containsString("dirty")));
        Keyboard.press(F3);
        assertThat(component(Div.class, "_f3").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f4").classname(), not(containsString("dirty")));
        Keyboard.press(F4);
        assertThat(component(Div.class, "_f4").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f5").classname(), not(containsString("dirty")));
        Keyboard.press(F5);
        assertThat(component(Div.class, "_f5").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f6").classname(), not(containsString("dirty")));
        Keyboard.press(F6);
        assertThat(component(Div.class, "_f6").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f7").classname(), not(containsString("dirty")));
        Keyboard.press(F7);
        assertThat(component(Div.class, "_f7").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f8").classname(), not(containsString("dirty")));
        Keyboard.press(F8);
        assertThat(component(Div.class, "_f8").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f9").classname(), not(containsString("dirty")));
        Keyboard.press(F9);
        assertThat(component(Div.class, "_f9").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f10").classname(), not(containsString("dirty")));
        Keyboard.press(F10);
        assertThat(component(Div.class, "_f10").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f11").classname(), not(containsString("dirty")));
        Keyboard.press(F11);
        assertThat(component(Div.class, "_f11").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_f12").classname(), not(containsString("dirty")));
        Keyboard.press(F12);
        assertThat(component(Div.class, "_f12").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_0").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD0);
        assertThat(component(Div.class, "_0").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_1").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD1);
        assertThat(component(Div.class, "_1").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_2").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD2);
        assertThat(component(Div.class, "_2").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_3").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD3);
        assertThat(component(Div.class, "_3").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_4").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD4);
        assertThat(component(Div.class, "_4").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_5").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD5);
        assertThat(component(Div.class, "_5").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_6").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD6);
        assertThat(component(Div.class, "_6").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_7").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD7);
        assertThat(component(Div.class, "_7").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_8").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD8);
        assertThat(component(Div.class, "_8").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_9").classname(), not(containsString("dirty")));
        Keyboard.press(NUMPAD9);
        assertThat(component(Div.class, "_9").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_backspace").classname(), not(containsString("dirty")));
        Keyboard.press(BACKSPACE);
        assertThat(component(Div.class, "_backspace").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_tab").classname(), not(containsString("dirty")));
        Keyboard.press(TAB);
        assertThat(component(Div.class, "_tab").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_return").classname(), not(containsString("dirty")));
        Keyboard.press(ENTER);
        assertThat(component(Div.class, "_return").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_pause").classname(), not(containsString("dirty")));
        Keyboard.press(PAUSE);
        assertThat(component(Div.class, "_pause").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_esc").classname(), not(containsString("dirty")));
        Keyboard.press(ESCAPE);
        assertThat(component(Div.class, "_esc").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_space").classname(), not(containsString("dirty")));
        Keyboard.press(SPACE);
        assertThat(component(Div.class, "_space").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_pageup").classname(), not(containsString("dirty")));
        Keyboard.press(PAGE_UP);
        assertThat(component(Div.class, "_pageup").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_pagedown").classname(), not(containsString("dirty")));
        Keyboard.press(PAGE_DOWN);
        assertThat(component(Div.class, "_pagedown").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_end").classname(), not(containsString("dirty")));
        Keyboard.press(END);
        assertThat(component(Div.class, "_end").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_home").classname(), not(containsString("dirty")));
        Keyboard.press(HOME);
        assertThat(component(Div.class, "_home").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_left").classname(), not(containsString("dirty")));
        Keyboard.press(LEFT_ARROW);
        assertThat(component(Div.class, "_left").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_up").classname(), not(containsString("dirty")));
        Keyboard.press(UP_ARROW);
        assertThat(component(Div.class, "_up").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_right").classname(), not(containsString("dirty")));
        Keyboard.press(RIGHT_ARROW);
        assertThat(component(Div.class, "_right").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_down").classname(), not(containsString("dirty")));
        Keyboard.press(DOWN_ARROW);
        assertThat(component(Div.class, "_down").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_insert").classname(), not(containsString("dirty")));
        Keyboard.press(INSERT);
        assertThat(component(Div.class, "_insert").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_del").classname(), not(containsString("dirty")));
        Keyboard.press(DELETE);
        assertThat(component(Div.class, "_del").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_scroll").classname(), not(containsString("dirty")));
        Keyboard.press(SCROLL_LOCK);
        assertThat(component(Div.class, "_scroll").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_capslock").classname(), not(containsString("dirty")));
        Keyboard.press(CAPS_LOCK);
        assertThat(component(Div.class, "_capslock").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_numlock").classname(), not(containsString("dirty")));
        Keyboard.press(NUM_LOCK);
        assertThat(component(Div.class, "_numlock").classname(), containsString("dirty"));

//    ADD,
//    MULTIPLY,
//    SUBTRACT,
//    DIVIDE,
    }

    @Test
    public void can_test_CONTROL_Key() {
        Keyboard.keyDown(CONTROL);

        assertThat(component(Div.class, "_Ctrl_esc").classname(), not(containsString("dirty")));
        Keyboard.press(ESCAPE);
        assertThat(component(Div.class, "_Ctrl_esc").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_tab").classname(), not(containsString("dirty")));
        Keyboard.press(TAB);
        assertThat(component(Div.class, "_Ctrl_tab").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_space").classname(), not(containsString("dirty")));
        Keyboard.press(SPACE);
        assertThat(component(Div.class, "_Ctrl_space").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_return").classname(), not(containsString("dirty")));
        Keyboard.press(ENTER);
        assertThat(component(Div.class, "_Ctrl_return").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_backspace").classname(), not(containsString("dirty")));
        Keyboard.press(BACKSPACE);
        assertThat(component(Div.class, "_Ctrl_backspace").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_scroll").classname(), not(containsString("dirty")));
        Keyboard.press(SCROLL_LOCK);
        assertThat(component(Div.class, "_Ctrl_scroll").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_capslock").classname(), not(containsString("dirty")));
        Keyboard.press(CAPS_LOCK);
        assertThat(component(Div.class, "_Ctrl_capslock").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_numlock").classname(), not(containsString("dirty")));
        Keyboard.press(NUM_LOCK);
        assertThat(component(Div.class, "_Ctrl_numlock").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_pause").classname(), not(containsString("dirty")));
        Keyboard.press(PAUSE);
        assertThat(component(Div.class, "_Ctrl_pause").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_insert").classname(), not(containsString("dirty")));
        Keyboard.press(INSERT);
        assertThat(component(Div.class, "_Ctrl_insert").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_home").classname(), not(containsString("dirty")));
        Keyboard.press(HOME);
        assertThat(component(Div.class, "_Ctrl_home").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_del").classname(), not(containsString("dirty")));
        Keyboard.press(DELETE);
        assertThat(component(Div.class, "_Ctrl_del").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_end").classname(), not(containsString("dirty")));
        Keyboard.press(END);
        assertThat(component(Div.class, "_Ctrl_end").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_pageup").classname(), not(containsString("dirty")));
        Keyboard.press(PAGE_UP);
        assertThat(component(Div.class, "_Ctrl_pageup").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_pagedown").classname(), not(containsString("dirty")));
        Keyboard.press(PAGE_DOWN);
        assertThat(component(Div.class, "_Ctrl_pagedown").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_left").classname(), not(containsString("dirty")));
        Keyboard.press(LEFT_ARROW);
        assertThat(component(Div.class, "_Ctrl_left").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_up").classname(), not(containsString("dirty")));
        Keyboard.press(UP_ARROW);
        assertThat(component(Div.class, "_Ctrl_up").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_right").classname(), not(containsString("dirty")));
        Keyboard.press(RIGHT_ARROW);
        assertThat(component(Div.class, "_Ctrl_right").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_down").classname(), not(containsString("dirty")));
        Keyboard.press(DOWN_ARROW);
        assertThat(component(Div.class, "_Ctrl_down").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f1").classname(), not(containsString("dirty")));
        Keyboard.press(F1);
        assertThat(component(Div.class, "_Ctrl_f1").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f2").classname(), not(containsString("dirty")));
        Keyboard.press(F2);
        assertThat(component(Div.class, "_Ctrl_f2").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f3").classname(), not(containsString("dirty")));
        Keyboard.press(F3);
        assertThat(component(Div.class, "_Ctrl_f3").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f4").classname(), not(containsString("dirty")));
        Keyboard.press(F4);
        assertThat(component(Div.class, "_Ctrl_f4").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f5").classname(), not(containsString("dirty")));
        Keyboard.press(F5);
        assertThat(component(Div.class, "_Ctrl_f5").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f6").classname(), not(containsString("dirty")));
        Keyboard.press(F6);
        assertThat(component(Div.class, "_Ctrl_f6").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f7").classname(), not(containsString("dirty")));
        Keyboard.press(F7);
        assertThat(component(Div.class, "_Ctrl_f7").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f8").classname(), not(containsString("dirty")));
        Keyboard.press(F8);
        assertThat(component(Div.class, "_Ctrl_f8").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f9").classname(), not(containsString("dirty")));
        Keyboard.press(F9);
        assertThat(component(Div.class, "_Ctrl_f9").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f10").classname(), not(containsString("dirty")));
        Keyboard.press(F10);
        assertThat(component(Div.class, "_Ctrl_f10").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f11").classname(), not(containsString("dirty")));
        Keyboard.press(F11);
        assertThat(component(Div.class, "_Ctrl_f11").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Ctrl_f12").classname(), not(containsString("dirty")));
        Keyboard.press(F12);
        assertThat(component(Div.class, "_Ctrl_f12").classname(), containsString("dirty"));

        Keyboard.release();
    }

    @Test
    public void can_test_SHIFT_Key() {
        Keyboard.keyDown(SHIFT);

        assertThat(component(Div.class, "_Shift_esc").classname(), not(containsString("dirty")));
        Keyboard.press(ESCAPE);
        assertThat(component(Div.class, "_Shift_esc").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_tab").classname(), not(containsString("dirty")));
        Keyboard.press(TAB);
        assertThat(component(Div.class, "_Shift_tab").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_space").classname(), not(containsString("dirty")));
        Keyboard.press(SPACE);
        assertThat(component(Div.class, "_Shift_space").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_return").classname(), not(containsString("dirty")));
        Keyboard.press(ENTER);
        assertThat(component(Div.class, "_Shift_return").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_backspace").classname(), not(containsString("dirty")));
        Keyboard.press(BACKSPACE);
        assertThat(component(Div.class, "_Shift_backspace").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_scroll").classname(), not(containsString("dirty")));
        Keyboard.press(SCROLL_LOCK);
        assertThat(component(Div.class, "_Shift_scroll").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_capslock").classname(), not(containsString("dirty")));
        Keyboard.press(CAPS_LOCK);
        assertThat(component(Div.class, "_Shift_capslock").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_numlock").classname(), not(containsString("dirty")));
        Keyboard.press(NUM_LOCK);
        assertThat(component(Div.class, "_Shift_numlock").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_pause").classname(), not(containsString("dirty")));
        Keyboard.press(PAUSE);
        assertThat(component(Div.class, "_Shift_pause").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_insert").classname(), not(containsString("dirty")));
        Keyboard.press(INSERT);
        assertThat(component(Div.class, "_Shift_insert").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_home").classname(), not(containsString("dirty")));
        Keyboard.press(HOME);
        assertThat(component(Div.class, "_Shift_home").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_del").classname(), not(containsString("dirty")));
        Keyboard.press(DELETE);
        assertThat(component(Div.class, "_Shift_del").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_end").classname(), not(containsString("dirty")));
        Keyboard.press(END);
        assertThat(component(Div.class, "_Shift_end").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_pageup").classname(), not(containsString("dirty")));
        Keyboard.press(PAGE_UP);
        assertThat(component(Div.class, "_Shift_pageup").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_pagedown").classname(), not(containsString("dirty")));
        Keyboard.press(PAGE_DOWN);
        assertThat(component(Div.class, "_Shift_pagedown").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_left").classname(), not(containsString("dirty")));
        Keyboard.press(LEFT_ARROW);
        assertThat(component(Div.class, "_Shift_left").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_up").classname(), not(containsString("dirty")));
        Keyboard.press(UP_ARROW);
        assertThat(component(Div.class, "_Shift_up").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_right").classname(), not(containsString("dirty")));
        Keyboard.press(RIGHT_ARROW);
        assertThat(component(Div.class, "_Shift_right").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_down").classname(), not(containsString("dirty")));
        Keyboard.press(DOWN_ARROW);
        assertThat(component(Div.class, "_Shift_down").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f1").classname(), not(containsString("dirty")));
        Keyboard.press(F1);
        assertThat(component(Div.class, "_Shift_f1").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f2").classname(), not(containsString("dirty")));
        Keyboard.press(F2);
        assertThat(component(Div.class, "_Shift_f2").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f3").classname(), not(containsString("dirty")));
        Keyboard.press(F3);
        assertThat(component(Div.class, "_Shift_f3").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f4").classname(), not(containsString("dirty")));
        Keyboard.press(F4);
        assertThat(component(Div.class, "_Shift_f4").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f5").classname(), not(containsString("dirty")));
        Keyboard.press(F5);
        assertThat(component(Div.class, "_Shift_f5").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f6").classname(), not(containsString("dirty")));
        Keyboard.press(F6);
        assertThat(component(Div.class, "_Shift_f6").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f7").classname(), not(containsString("dirty")));
        Keyboard.press(F7);
        assertThat(component(Div.class, "_Shift_f7").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f8").classname(), not(containsString("dirty")));
        Keyboard.press(F8);
        assertThat(component(Div.class, "_Shift_f8").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f9").classname(), not(containsString("dirty")));
        Keyboard.press(F9);
        assertThat(component(Div.class, "_Shift_f9").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f10").classname(), not(containsString("dirty")));
        Keyboard.press(F10);
        assertThat(component(Div.class, "_Shift_f10").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f11").classname(), not(containsString("dirty")));
        Keyboard.press(F11);
        assertThat(component(Div.class, "_Shift_f11").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Shift_f12").classname(), not(containsString("dirty")));
        Keyboard.press(F12);
        assertThat(component(Div.class, "_Shift_f12").classname(), containsString("dirty"));

        Keyboard.release();
    }

    @Test
    public void can_test_ALT_Key() {
        Keyboard.keyDown(ALT);

        assertThat(component(Div.class, "_Alt_esc").classname(), not(containsString("dirty")));
        Keyboard.press(ESCAPE);
        assertThat(component(Div.class, "_Alt_esc").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_tab").classname(), not(containsString("dirty")));
        Keyboard.press(TAB);
        assertThat(component(Div.class, "_Alt_tab").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_space").classname(), not(containsString("dirty")));
        Keyboard.press(SPACE);
        assertThat(component(Div.class, "_Alt_space").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_return").classname(), not(containsString("dirty")));
        Keyboard.press(ENTER);
        assertThat(component(Div.class, "_Alt_return").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_backspace").classname(), not(containsString("dirty")));
        Keyboard.press(BACKSPACE);
        assertThat(component(Div.class, "_Alt_backspace").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_scroll").classname(), not(containsString("dirty")));
        Keyboard.press(SCROLL_LOCK);
        assertThat(component(Div.class, "_Alt_scroll").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_capslock").classname(), not(containsString("dirty")));
        Keyboard.press(CAPS_LOCK);
        assertThat(component(Div.class, "_Alt_capslock").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_numlock").classname(), not(containsString("dirty")));
        Keyboard.press(NUM_LOCK);
        assertThat(component(Div.class, "_Alt_numlock").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_pause").classname(), not(containsString("dirty")));
        Keyboard.press(PAUSE);
        assertThat(component(Div.class, "_Alt_pause").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_insert").classname(), not(containsString("dirty")));
        Keyboard.press(INSERT);
        assertThat(component(Div.class, "_Alt_insert").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_home").classname(), not(containsString("dirty")));
        Keyboard.press(HOME);
        assertThat(component(Div.class, "_Alt_home").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_del").classname(), not(containsString("dirty")));
        Keyboard.press(DELETE);
        assertThat(component(Div.class, "_Alt_del").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_end").classname(), not(containsString("dirty")));
        Keyboard.press(END);
        assertThat(component(Div.class, "_Alt_end").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_pageup").classname(), not(containsString("dirty")));
        Keyboard.press(PAGE_UP);
        assertThat(component(Div.class, "_Alt_pageup").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_pagedown").classname(), not(containsString("dirty")));
        Keyboard.press(PAGE_DOWN);
        assertThat(component(Div.class, "_Alt_pagedown").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_left").classname(), not(containsString("dirty")));
        Keyboard.press(LEFT_ARROW);
        assertThat(component(Div.class, "_Alt_left").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_up").classname(), not(containsString("dirty")));
        Keyboard.press(UP_ARROW);
        assertThat(component(Div.class, "_Alt_up").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_right").classname(), not(containsString("dirty")));
        Keyboard.press(RIGHT_ARROW);
        assertThat(component(Div.class, "_Alt_right").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_down").classname(), not(containsString("dirty")));
        Keyboard.press(DOWN_ARROW);
        assertThat(component(Div.class, "_Alt_down").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f1").classname(), not(containsString("dirty")));
        Keyboard.press(F1);
        assertThat(component(Div.class, "_Alt_f1").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f2").classname(), not(containsString("dirty")));
        Keyboard.press(F2);
        assertThat(component(Div.class, "_Alt_f2").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f3").classname(), not(containsString("dirty")));
        Keyboard.press(F3);
        assertThat(component(Div.class, "_Alt_f3").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f4").classname(), not(containsString("dirty")));
        Keyboard.press(F4);
        assertThat(component(Div.class, "_Alt_f4").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f5").classname(), not(containsString("dirty")));
        Keyboard.press(F5);
        assertThat(component(Div.class, "_Alt_f5").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f6").classname(), not(containsString("dirty")));
        Keyboard.press(F6);
        assertThat(component(Div.class, "_Alt_f6").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f7").classname(), not(containsString("dirty")));
        Keyboard.press(F7);
        assertThat(component(Div.class, "_Alt_f7").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f8").classname(), not(containsString("dirty")));
        Keyboard.press(F8);
        assertThat(component(Div.class, "_Alt_f8").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f9").classname(), not(containsString("dirty")));
        Keyboard.press(F9);
        assertThat(component(Div.class, "_Alt_f9").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f10").classname(), not(containsString("dirty")));
        Keyboard.press(F10);
        assertThat(component(Div.class, "_Alt_f10").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f11").classname(), not(containsString("dirty")));
        Keyboard.press(F11);
        assertThat(component(Div.class, "_Alt_f11").classname(), containsString("dirty"));

        assertThat(component(Div.class, "_Alt_f12").classname(), not(containsString("dirty")));
        Keyboard.press(F12);
        assertThat(component(Div.class, "_Alt_f12").classname(), containsString("dirty"));

        Keyboard.release();
    }

}

