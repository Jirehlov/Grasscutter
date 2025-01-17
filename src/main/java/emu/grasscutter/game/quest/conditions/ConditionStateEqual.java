package emu.grasscutter.game.quest.conditions;

import emu.grasscutter.data.excels.quest.QuestData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.QuestValueCond;

import static emu.grasscutter.game.quest.enums.QuestCond.QUEST_COND_STATE_EQUAL;

@QuestValueCond(QUEST_COND_STATE_EQUAL)
public class ConditionStateEqual extends BaseCondition {

    @Override
    public boolean execute(
            Player owner,
            QuestData questData,
            QuestData.QuestAcceptCondition condition,
            String paramStr,
            int... params) {
        var questId = condition.getParam()[0];
        var questStateValue = condition.getParam()[1];
        var checkQuest = owner.getQuestManager().getQuestById(questId);

        return checkQuest != null && checkQuest.getState().getValue() == questStateValue;
    }
}
