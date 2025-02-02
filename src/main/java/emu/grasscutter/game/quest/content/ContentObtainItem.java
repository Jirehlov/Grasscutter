package emu.grasscutter.game.quest.content;

import emu.grasscutter.data.excels.quest.QuestData;
import emu.grasscutter.game.quest.*;
import lombok.val;

import static emu.grasscutter.game.quest.enums.QuestContent.QUEST_CONTENT_OBTAIN_ITEM;

@QuestValueContent(QUEST_CONTENT_OBTAIN_ITEM)
public class ContentObtainItem extends BaseContent {
    @Override
    public boolean execute(
            GameQuest quest, QuestData.QuestContentCondition condition, String paramStr, int... params) {
        val itemId = condition.getParam()[0];
        var targetAmount = condition.getCount();
        if (targetAmount == 0) {
            targetAmount = 1;
        }
        val amount = quest.getOwner().getInventory().getItemCountById(itemId);
        return amount >= targetAmount;
    }
}
