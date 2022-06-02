package com.architecturelab.inventory.useCases.item;

import com.architecturelab.inventory.core.domain.item.ItemOutput;
import com.architecturelab.inventory.infra.kafka.producer.MessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemOutputUseCasesImpl implements ItemOutputUseCases {

    @Autowired
    private MessageProducer messageProducer;

    @Override
    public ItemOutput execute() {
        messageProducer.sendMessage(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> POr aquí andamos mandando un mensajito");
        return null;
    }
}
