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

/**
 * This enum gives the different html4 elements
 *
 * @author dev@testatoo.org
 */

public enum HtmlElementType {
    A, Abbr, Acronym, Area, Base, Button, Caption, Cite, CheckBox, Code, Col,
    Colgroup, Dd, Dfn, Div, Span, Dl, DropDown, Dt, Em, FieldSet, File, Form, Frame, FrameSet,
    Hidden, IFrame, Img, Input, InputPassword, InputText, Kbd, Label, Legend, Li, Link, ListBox, Map,
    NoFrames, Object, Ol, Option, OptionGroup, Param, Password, Radio, Samp, Script,
    Select, Strong, Table, TBody, Td, TextArea, TFoot, Th, THead, Tr, Ul, Var, Undefined, P, Title;

    public static HtmlElementType valueOfIgnoreCase(String value) {
        if (value.equalsIgnoreCase("A")) return A;
        if (value.equalsIgnoreCase("Abbr")) return Abbr;
        if (value.equalsIgnoreCase("Acronym")) return Acronym;
        if (value.equalsIgnoreCase("Area")) return Area;
        if (value.equalsIgnoreCase("Base")) return Base;
        if (value.equalsIgnoreCase("Button")) return Button;
        if (value.equalsIgnoreCase("Caption")) return Caption;
        if (value.equalsIgnoreCase("Cite")) return Cite;
        if (value.equalsIgnoreCase("CheckBox")) return CheckBox;
        if (value.equalsIgnoreCase("Code")) return Code;
        if (value.equalsIgnoreCase("Col")) return Col;
        if (value.equalsIgnoreCase("Colgroup")) return Colgroup;
        if (value.equalsIgnoreCase("Dd")) return Dd;
        if (value.equalsIgnoreCase("Dfn")) return Dfn;
        if (value.equalsIgnoreCase("Div")) return Div;
        if (value.equalsIgnoreCase("Span")) return Span;
        if (value.equalsIgnoreCase("Dl")) return Dl;
        if (value.equalsIgnoreCase("DropDown")) return DropDown;
        if (value.equalsIgnoreCase("Dt")) return Dt;
        if (value.equalsIgnoreCase("Em")) return Em;
        if (value.equalsIgnoreCase("FieldSet")) return FieldSet;
        if (value.equalsIgnoreCase("File")) return File;
        if (value.equalsIgnoreCase("Form")) return Form;
        if (value.equalsIgnoreCase("Frame")) return Frame;
        if (value.equalsIgnoreCase("FrameSet")) return FrameSet;
        if (value.equalsIgnoreCase("Hidden")) return Hidden;
        if (value.equalsIgnoreCase("IFrame")) return IFrame;
        if (value.equalsIgnoreCase("Img")) return Img;
        if (value.equalsIgnoreCase("Input")) return Input;
        if (value.equalsIgnoreCase("InputPassword")) return InputPassword;
        if (value.equalsIgnoreCase("InputText")) return InputText;
        if (value.equalsIgnoreCase("Kbd")) return Kbd;
        if (value.equalsIgnoreCase("Label")) return Label;
        if (value.equalsIgnoreCase("Legend")) return Legend;
        if (value.equalsIgnoreCase("Li")) return Li;
        if (value.equalsIgnoreCase("Link")) return Link;
        if (value.equalsIgnoreCase("ListBox")) return ListBox;
        if (value.equalsIgnoreCase("Map")) return Map;
        if (value.equalsIgnoreCase("NoFrames")) return NoFrames;
        if (value.equalsIgnoreCase("Object")) return Object;
        if (value.equalsIgnoreCase("Ol")) return Ol;
        if (value.equalsIgnoreCase("Option")) return Option;
        if (value.equalsIgnoreCase("OptionGroup")) return OptionGroup;
        if (value.equalsIgnoreCase("Param")) return Param;
        if (value.equalsIgnoreCase("Password")) return Password;
        if (value.equalsIgnoreCase("Radio")) return Radio;
        if (value.equalsIgnoreCase("Samp")) return Samp;
        if (value.equalsIgnoreCase("Script")) return Script;
        if (value.equalsIgnoreCase("Select")) return Select;
        if (value.equalsIgnoreCase("Strong")) return Strong;
        if (value.equalsIgnoreCase("Table")) return Table;
        if (value.equalsIgnoreCase("TBody")) return TBody;
        if (value.equalsIgnoreCase("Td")) return Td;
        if (value.equalsIgnoreCase("TextArea")) return TextArea;
        if (value.equalsIgnoreCase("TFoot")) return TFoot;
        if (value.equalsIgnoreCase("Th")) return Th;
        if (value.equalsIgnoreCase("THead")) return THead;
        if (value.equalsIgnoreCase("Tr")) return Tr;
        if (value.equalsIgnoreCase("Ul")) return Ul;
        if (value.equalsIgnoreCase("Var")) return Var;
        if (value.equalsIgnoreCase("P")) return P;
        if (value.equalsIgnoreCase("H1") || value.equalsIgnoreCase("H2")
                || value.equalsIgnoreCase("H3") || value.equalsIgnoreCase("H4")
                || value.equalsIgnoreCase("H5") || value.equalsIgnoreCase("H6")
                ) return Title;

        return Undefined;
    }
}
