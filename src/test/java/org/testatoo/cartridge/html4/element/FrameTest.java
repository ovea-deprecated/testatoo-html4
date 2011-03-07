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
import org.junit.Ignore;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.ComponentException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class FrameTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Frame.html");
    }

    //---------- FrameSet --------------------
    @Test
    public void can_find_frameSet_by_id() {
        component(FrameSet.class, "frameset_1");

        try {
            component(FrameSet.class, "frameset_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=frameset_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_frameset() {
        try {
            component(FrameSet.class, "frame_1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=frame_1 is not a FrameSet but a Frame"));
        }
    }

    @Test
    public void test_frameSet_coreAttributes() {
        FrameSet frameset_1 = component(FrameSet.class, "frameset_1");

        assertThat(frameset_1.id(), is("frameset_1"));
        assertThat(frameset_1.classname(), is("MyFRAMESETClass"));
        assertThat(frameset_1.style(), containsString("color:blue"));
        assertThat(frameset_1.title(), is("framesetTitle1"));
    }

    @Test
    public void test_frameSet_specifics_attributes() {
        FrameSet frameset_1 = component(FrameSet.class, "frameset_1");
        FrameSet frameset_2 = component(FrameSet.class, "frameset_2");

        assertThat(frameset_1.cols(), is("20%, 80%"));
        assertThat(frameset_1.rows(), is(""));
        assertThat(frameset_2.cols(), is(""));
        assertThat(frameset_2.rows(), is("100, 200"));
    }

    @Test
    public void test_frameset_toString() {
        assertThat(component(FrameSet.class, "frameset_1").toString(), is("class org.testatoo.cartridge.html4.element.FrameSet with state : enabled:true, visible:true, title:framesetTitle1"));
    }

    //---------- Frame --------------------
    @Test
    public void can_find_frame_by_id() {
        component(Frame.class, "frame_1");

        try {
            component(Frame.class, "frame_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=frame_0"));
        }
    }

    @Test
    @Ignore
    public void exception_thrown_if_component_not_a_html_frame() {
        try {
            component(Frame.class, "myDiv");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=noFrames_1 is not a Frame but a NoFrames"));
        }
    }

    @Test
    public void test_frame_coreAttributes() {
        Frame frame_1 = component(Frame.class, "frame_1");

        assertThat(frame_1.id(), is("frame_1"));
        assertThat(frame_1.classname(), is("MyFRAMEClass"));
        assertThat(frame_1.style(), containsString("color:brown"));
        assertThat(frame_1.title(), is("frameTitle1"));
    }

    @Test
    public void test_frame_specifics_attributes() {
        Frame frame_1 = component(Frame.class, "frame_1");
        Frame frame_2 = component(Frame.class, "frame_2");

        assertThat(frame_1.name(), is("frameName1"));
        assertThat(frame_1.frameborder(), is(1));
        assertThat(frame_2.frameborder(), is(0));
        assertThat(frame_2.longdesc(), is("Label.html"));
        assertThat(frame_2.marginheight(), is(30));
        assertThat(frame_2.marginwidth(), is(40));
        assertThat(frame_1.scrolling(), is(Scrolling.no));
        assertThat(frame_1.src(), is("Button.html"));
        assertThat(frame_1.noresize(), is(false));
        assertThat(frame_2.noresize(), is(true));
    }

    @Test
    public void test_frame_toString() {
        assertThat(component(Frame.class, "frame_1").toString(), is("class org.testatoo.cartridge.html4.element.Frame with state : enabled:true, visible:true, title:frameTitle1"));
    }

    //---------- NoFrames --------------------
    // This test are set to Ignore cause tag is deprecated
    // and in webkit seems to be removed of the DOM when page is loaded
    @Test
    @Ignore
    public void can_find_noFrames_by_id() {
        component(NoFrames.class, "noFrames_1");

        try {
            component(NoFrames.class, "noFrames_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=noFrames_0"));
        }
    }

    @Test
    @Ignore
    public void exception_thrown_if_component_not_a_html_noframes() {
        try {
            component(NoFrames.class, "frameset_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=frameset_2 is not a NoFrames but a FrameSet"));
        }
    }

    @Test
    @Ignore
    public void test_noFrames_coreAttributes() {
        NoFrames noFrames_1 = component(NoFrames.class, "noFrames_1");

        assertThat(noFrames_1.title(), is("noFramesTitle1"));
        assertThat(noFrames_1.id(), is("noFrames_1"));
        assertThat(noFrames_1.style(), containsString("font-size:10pt"));
        assertThat(noFrames_1.classname(), is("MyNOFRAMESClass"));
    }

    @Test
    @Ignore
    public void test_noFrames_i18nAttributes() {
        NoFrames noFrames_1 = component(NoFrames.class, "noFrames_1");

        assertThat(noFrames_1.language(), is("ar"));
        assertThat(noFrames_1.direction(), is(Direction.righttoleft));
    }

    @Test
    @Ignore
    public void test_noframes_toString() {
        // in this case, our browser supports frames, so noframes is not visible
        assertThat(component(NoFrames.class, "noFrames_1").toString(), is("class org.testatoo.cartridge.html4.element.NoFrames with state : enabled:true, visible:false, title:noFramesTitle1"));
    }
}
