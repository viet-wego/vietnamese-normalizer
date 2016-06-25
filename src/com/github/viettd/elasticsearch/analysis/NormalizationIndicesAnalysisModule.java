/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viettd.elasticsearch.analysis;

import org.elasticsearch.common.inject.AbstractModule;

/**
 *
 * @author viettd
 */
public class NormalizationIndicesAnalysisModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(NormalizationIndicesAnalysis.class).asEagerSingleton();
    }

}
