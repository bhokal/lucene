package org.apache.lucene.queryParser.standard.processors;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.List;

import org.apache.lucene.queryParser.core.nodes.QueryNode;
import org.apache.lucene.queryParser.core.nodes.WildcardQueryNode;
import org.apache.lucene.queryParser.core.nodes.PrefixWildcardQueryNode;
import org.apache.lucene.queryParser.core.processors.QueryNodeProcessorImpl;
import org.apache.lucene.search.MultiTermQuery;

/**
 * This processor instates the default {@link
 * MultiTermQuery.RewriteMethod}, {@link
 * MultiTermQuery#CONSTANT_SCORE_AUTO_REWRITE_DEFAULT}, for
 * multi-term query nodes.
 */
public class MultiTermRewriteDefaultProcessor extends QueryNodeProcessorImpl {

  protected QueryNode postProcessNode(QueryNode node) {
    if (node instanceof WildcardQueryNode) {
      ((WildcardQueryNode) node).setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_AUTO_REWRITE_DEFAULT);
    } else if (node instanceof PrefixWildcardQueryNode) {
      ((PrefixWildcardQueryNode) node).setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_AUTO_REWRITE_DEFAULT);
    }

    return node;
  }

  protected QueryNode preProcessNode(QueryNode node) {
    return node;
  }

  protected List<QueryNode> setChildrenOrder(List<QueryNode> children) {
    return children;
  }
}