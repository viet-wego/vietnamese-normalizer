/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viettd.elasticsearch.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.KeywordTokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;

/**
 *
 * @author viettd
 */
public class NormalizedKeyWordAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String string) {
        Tokenizer tokenizer = new KeywordTokenizer();
        TokenStream filter = new NormalizationTokenFilter(tokenizer);
        return new TokenStreamComponents(tokenizer, filter);
    }

}
