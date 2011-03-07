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

package org.testatoo.core;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.component.FileDialog;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

// Test not available for security constraints :

// We cannot set/get the value of the input text file (only done by the user)
@Ignore
public class FileDialogTest extends WebTest {

    @Before
    public void setUp() {
        page().open("File.html");
    }

    @Test
    public void can_find_fileDialog_by_id() {
        component(FileDialog.class, "file");

        try {
            component(FileDialog.class, "other");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=other"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_fileDialog() {
        try {
            component(FileDialog.class, "radio");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a FileDialog but a Radio"));
        }
    }

    @Test
    public void can_select_file_path() {
        FileDialog fileDialog = component(FileDialog.class, "file");
        assertThat(fileDialog.selectedFilePath(), is(""));
        fileDialog.selectFilePath("/home/testatoo/file.txt");
        assertThat(fileDialog.selectedFilePath(), is("/home/testatoo/file.txt"));
    }

    @Test
    public void test_toString() {
        FileDialog fileDialog = component(FileDialog.class, "file");
        fileDialog.selectFilePath("/home/testatoo/file.txt");
        assertThat(fileDialog.toString(), is("class org.testatoo.cartridge.html4.element.File with state : enabled:true, visible:true, title:fileTitle, selectedFilePath:/home/testatoo/file.txt"));
    }
}
