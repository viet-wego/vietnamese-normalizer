/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viettd.elasticsearch.analysis;

import com.github.viettd.elasticsearch.utils.StringNormalizer;
import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;

/**
 *
 * @author viettd
 */
public class NormalizationTokenFilter extends TokenFilter {

    protected CharTermAttribute charTermAttribute
            = addAttribute(CharTermAttribute.class);
    protected PositionIncrementAttribute positionIncrementAttribute
            = addAttribute(PositionIncrementAttribute.class);

    @Override
    public boolean incrementToken() throws IOException {
        String nextToken = null;
        while (nextToken == null) {
            if (!this.input.incrementToken()) {
                return false;
            }
            String currentTokenInStream
                    = this.input.getAttribute(CharTermAttribute.class)
                    .toString().trim();
            nextToken = StringNormalizer.normalize(currentTokenInStream);
        }
        this.charTermAttribute.setEmpty().append(nextToken);
        this.positionIncrementAttribute.setPositionIncrement(1);
        return true;
    }

    public NormalizationTokenFilter(TokenStream input) {
        super(input);
    }

    
}
