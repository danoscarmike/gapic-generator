/* Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.api.codegen.configgen.nodes;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.codegen.configgen.nodes.metadata.Comment;
import com.google.api.codegen.configgen.nodes.metadata.DefaultComment;
import org.junit.Test;

public class FieldConfigNodeTest {
  @Test
  public void testChild() throws Exception {
    FieldConfigNode node = new FieldConfigNode(0, "foo");
    ConfigNode child = new ScalarConfigNode(0, "bar");
    assertThat(node.getChild().isPresent()).isFalse();
    assertThat(node.setChild(child)).isSameAs(node);
    assertThat(node.getChild()).isSameAs(child);
  }

  @Test
  public void testComment() throws Exception {
    FieldConfigNode node = new FieldConfigNode(0, "foo");
    Comment comment = new DefaultComment("Lorem ispum");
    assertThat(node.getComment().generate()).isEqualTo("");
    assertThat(node.setComment(comment)).isSameAs(node);
    assertThat(node.getComment()).isSameAs(comment);
  }
}
