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

package org.testatoo.multisession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testatoo.cartridge.html4.element.*;
import org.testatoo.config.annotation.TestatooModules;
import org.testatoo.config.junit.TestatooJunitRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.hamcrest.Matchers.*;
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.cartridge.html4.Language.*;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.EvaluatorHolder.withEvaluator;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.matcher.Matchers.*;

@RunWith(TestatooJunitRunner.class)
@TestatooModules(SyncedParallelMultiSessionModule.class)
public class SyncedParallelMultiSessionTest {

    @Before
    public void setUp() {
        page().open("Form.html");
    }

    @Test
    public void can_reset_a_form() throws ExecutionException, InterruptedException {
        type("Joe", on(component(InputText.class, $("#firstname"))));
        type("Blow", into(component(InputText.class, $("#lastname"))));
        enter("email@noname.com", into(component(InputText.class, $("#email"))));

        check(component(Radio.class, $("#male")));
        check(component(CheckBox.class, $("[name=yes]")));

        on(component(Select.class, $("#cities"))).select("Casablanca");

        component(Form.class, $("#myForm")).reset();

        assertThat(component(InputText.class, $("#firstname")), has(value("")));
        assertThat(component(InputText.class, $("#lastname")), has(value("")));
        assertThat(component(InputText.class, $("#email")), has(value("")));

        assertThat(component(Radio.class, $("#male")), is(not(checked())));
        assertThat(component(CheckBox.class, $("[name=yes]")), is(not(checked())));

        assertThat(component(Select.class, $("#cities")).selectedOptions().get(0).content(), is("New York"));


        // Execute some other stuff and wait until finished when we need
        Future<?> job = withEvaluator("MY-OTHER-SESSION-NAME").runInParallel(new Runnable() {
            @Override
            public void run() {
                page().open("/");
                type("testatoo", on(component(InputText.class, $("[name=q]"))));
                clickOn(component(Button.class, $("[name=btnG]")));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {
                }
                clickOn(component(Button.class, $("[name=btnG]")));
            }
        });

        type("Joe", on(component(InputText.class, $("#firstname"))));
        type("Blow", into(component(InputText.class, $("#lastname"))));
        enter("email@noname.com", into(component(InputText.class, $("#email"))));

        check(component(Radio.class, $("#male")));
        check(component(CheckBox.class, $("[name=yes]")));

        on(component(Select.class, $("#cities"))).select("Casablanca");

        on(component(Form.class, $("#myForm"))).reset();

        // WAIT
        job.get();

        assertThat(component(InputText.class, $("#firstname")), has(value("")));
        assertThat(component(InputText.class, $("#lastname")), has(value("")));
        assertThat(component(InputText.class, $("#email")), has(value("")));

        assertThat(component(Radio.class, $("#male")), is(not(checked())));
        assertThat(component(CheckBox.class, $("[name=yes]")), is(not(checked())));

        assertThat(component(Select.class, $("#cities")).selectedOptions().get(0).content(), is("New York"));

    }

}
