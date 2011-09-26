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

package org.testatoo.cartridge.html4.element;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.ComponentException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;

public class FileTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("File.html");
    }

    @Test
    public void can_find_file_by_id() {
        component(File.class, "file");

        try {
            component(File.class, "file_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=file_2"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_file() {
        try {
            component(File.class, "radio");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a FileDialog but a Radio"));
        }
    }

    @Test
    public void can_retreive_attributes() {
        File file = component(File.class, "file");
        assertThat(file.name(), is("fileName"));

        assertThat(file.value(), is(""));
//        file.selectFilePath("myFile.doc"); // Throw exception for security constraint
//        assertThat(file.value(), is("myFile.doc"));

        assertThat(file.type(), is(InputType.file));
        assertThat(file.alt(), is("short description"));
        assertThat(file.tabindex(), is(5));
        assertThat(file.accesskey(), is("C"));
        assertThat(file.direction(), is(Direction.righttoleft));
        assertThat(file.language(), is("fr"));
        assertThat(file.classname(), is("myClass"));
        assertThat(file.id(), is("file"));
        assertThat(file.style(), containsString("color:black"));
        assertThat(file.title(), is("fileTitle"));
        assertThat(file.accept(), is("application/msword, application/rtf"));
    }

    @Test
    public void test_toString() {
        File file = component(File.class, "file2");
        assertThat(file.toString(), is("class org.testatoo.cartridge.html4.element.File with state : enabled:true, visible:true, title:fileTitle, selectedFilePath:"));
    }
}
