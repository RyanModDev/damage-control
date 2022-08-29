package dev.ryanccn.damage_control.config;

import dev.lambdaurora.spruceui.option.SpruceBooleanOption;
import dev.lambdaurora.spruceui.option.SpruceStringOption;
import dev.ryanccn.damage_control.DamageControlMod;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.option.SpruceOption;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.widget.SpruceButtonWidget;
import dev.lambdaurora.spruceui.widget.container.SpruceOptionListWidget;

import org.quiltmc.config.api.annotations.Comment;
import org.quiltmc.config.api.values.ValueTreeNode;
import org.quiltmc.config.api.values.TrackedValue;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.client.util.math.MatrixStack;

import it.unimi.dsi.fastutil.objects.Reference2ObjectArrayMap;

import java.util.Map;

public class DamageControlConfigScreen extends SpruceScreen {
    private final Screen parent;
    private SpruceOptionListWidget list;

    private Map<TrackedValue<Object>, Object> newValues;
    private SpruceOption optionBuffer;

    public DamageControlConfigScreen(Screen parent) {
        super(Text.of("Damage Control Config"));
        this.parent = parent;
        this.newValues = new Reference2ObjectArrayMap<>();
        this.optionBuffer = null;
    }

    @Override
    protected void init() {
        super.init();
        this.list = new SpruceOptionListWidget(Position.of(0, 22), this.width, this.height - 36 - 22);

        this.initializeOptionList(this.list);

        this.addDrawableChild(this.list);
        this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 - 154, this.height - 28), 150, 20, Text.of("Discard Changes"),
                btn -> {
                    this.resetNewValues();
                    this.refresh();
                }).asVanilla());
        this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 + 4, this.height - 28), 150, 20, Text.of("Done"),
                btn -> {
                    this.newValues.forEach((trackedValue, newValue) -> {
                        if (trackedValue.value() != null) {
                            trackedValue.setValue(newValue, false);
                        }
                    });
                    DamageControlConfigManager.CONFIG.save();
                    this.client.setScreen(this.parent);
                }).asVanilla());
    }

    @Override
    public void renderTitle(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 0xFFFFFF);
    }

    @Override
    public void removed() {
        this.newValues.forEach((trackedValue, newValue) -> trackedValue.setValue(newValue, false));
        DamageControlConfigManager.CONFIG.save();
    }

    @Override
    public void closeScreen() {
        this.client.setScreen(this.parent);
    }

    @SuppressWarnings("unchecked")
    private void resetNewValues() {
        this.newValues = new Reference2ObjectArrayMap<>();

        for (TrackedValue<?> trackedValue : DamageControlConfigManager.CONFIG.values()) {
            if (trackedValue.getRealValue() != null) {
                newValues.put((TrackedValue<Object>) trackedValue, trackedValue.getRealValue());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initializeOptionList(SpruceOptionListWidget options) {
        for (ValueTreeNode node : DamageControlConfigManager.CONFIG.nodes()) {
            if (node instanceof TrackedValue<?> trackedValue) {
                var trackie = (TrackedValue<Object>) trackedValue;
                this.newValues.putIfAbsent(trackie, trackedValue.getRealValue());

                if (trackedValue.value() instanceof Boolean) {
                    SpruceOption option;

                    option = new SpruceBooleanOption(
                            String.format("%s", trackedValue.key()),
                            () -> (Boolean) this.newValues.get(trackie),
                            value -> this.newValues.replace(trackie, value),
                            null
                    );

                    this.addOptionToList(options, option);
                } else if (trackedValue.value() instanceof String) {
                    SpruceOption option;

                    option = new SpruceStringOption(
                            String.format("%s", trackedValue.key()),
                            () -> (String) this.newValues.get(trackie),
                            value -> this.newValues.replace(trackie, value),
                            null, null
                    );

                    this.addOptionToList(options, option);
                } else {
                    DamageControlMod.LOGGER.warn("Unknown non-boolean config, we're not prepared O.o");
                }
            }
        }

        if (this.optionBuffer != null) {
            this.list.addOptionEntry(optionBuffer, null);
            this.optionBuffer = null;
        }
    }

    private void addOptionToList(SpruceOptionListWidget options, SpruceOption option) {
        if (optionBuffer != null) {
            this.list.addOptionEntry(optionBuffer, null);
            optionBuffer = null;
        }

        this.list.addSingleOptionEntry(option);
    }

    private void refresh() {
        var scrollAmount = this.list.getScrollAmount();
        this.init(client, width, height);
        this.list.setScrollAmount(scrollAmount);
    }
}
